package ru.mvp;

import ru.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Presenter {

    private View view;
    private TreeImple tree = null;

    public Presenter(View view) {
        this.view = view;
    }

    public void update() {
        FileManager save = new FileManager();
        view.setLoadCommand(createLoadCommand(save));
        view.setCommandSave(createReadCommand(save));
        view.setFindChildren(createPrintChildrenCommand());
        view.setPrintAllPeople(printAllPeople());
        view.setAddHuman(addHuman());
        view.setAboutHuman(aboutHuman());
        while (true) {
            view.update();
        }
    }

    private TreeImple initTre() {
        TreeImple tree = new TreeImple("Alexey", Gender.MAN);
        tree.addParents("Alexey", "Sveta", "Anatoliy");
        tree.addParents("Sveta", "Lena", "Enakentiy");
        tree.addParents("Anatoliy", "Anastasia", "Aleksandr");
        tree.addChild("Andrew", Gender.MAN, "Sveta", "Anatoliy");
        return tree;
    }

    private Command createLoadCommand(FileManager save) {
        return new Command() {
            @Override
            public void execute() {
                tree = initTre();
                try {
                    save.writeFile(tree);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    private Command createReadCommand(FileManager save) {
        return new Command() {
            @Override
            public void execute() {
                try {
                    tree = (TreeImple) save.readFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    private Command createPrintChildrenCommand() {
        return new Command() {
            @Override
            public void execute() {
                if (tree == null) {
                    System.out.println("Дерево не загружено");
                    return;
                }
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите имя  Sveta , Anatoliy, Lena, Enakentiy, Anastasia, Aleksandr, Alexey");
                String name = scanner.nextLine();
                Human result = tree.findHuman(name);
                System.out.println("Все дети " + result + " : ");
                for (Human hum : result.getChildren()) {
                    System.out.println(hum.getName());
                }
            }
        };
    }

    private Command printAllPeople() {
        return new Command() {
            @Override
            public void execute() {
                if (tree == null) {
                    System.out.println("Дерево не загружено");
                    return;
                }
                for (Human hum : tree) {
                    System.out.println(hum);
                }
            }
        };
    }

    private Command addHuman() {
        return new Command() {
            @Override
            public void execute() {
                if (tree == null) {
                    System.out.println("Дерево не загружено");
                    return;
                }
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите имя ; пол MAN,WOMAN; имя мамы ; имя папы");
                String name = scanner.nextLine();
                String gender = scanner.nextLine();
                String mother = scanner.nextLine();
                String father = scanner.nextLine();
                Human result = tree.addChild(name, Gender.valueOf(gender), mother, father);
                System.out.println("человек добавлен " + result + " : ");
                for (Human hum : result.getChildren()) {
                    System.out.println(hum.getName());
                }
            }
        };
    }

    private Command aboutHuman() {
        return new Command() {
            @Override
            public void execute() {
                if (tree == null) {
                    System.out.println("Дерево не загружено");
                    return;
                }
                Scanner scanner = new Scanner(System.in);
                System.out.println("Введите имя человека о котором вы хотите получить информацию");
                String name = scanner.nextLine();
                Human human = tree.findHuman(name);
                if (human != null) {
                    List<Human> list = tree.aboutPeople(human);
                    for (Human hum : list) {
                        System.out.println(hum.getName());
                    }

                } else {
                    System.out.println("чтото пошло не так");
                }

            }
        };
    }
}