import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static TreeImple tree = null;

    public static void main(String[] args) {
        FileManager save = new FileManager();
        ConsoleUi menu = new ConsoleUi();
        while (true) {
            menu.printMenu(createLoadCommand(save), createReadCommand(save), createPrintChildrenCommand(), printAllPeople());
        }
    }

    private static TreeImple initTre() {
        TreeImple tree = new TreeImple("Alexey", Gender.MAN);
        tree.addParents("Alexey", "Sveta", "Anatoliy");
        tree.addParents("Sveta", "Lena", "Enakentiy");
        tree.addParents("Anatoliy", "Anastasia", "Aleksandr");
        tree.addChild("Andrew", Gender.MAN, "Sveta", "Anatoliy");
        return tree;
    }

    private static Command createLoadCommand(FileManager save) {
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

    private static Command createReadCommand(FileManager save) {
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

    private static Command createPrintChildrenCommand() {
        return new Command() {
            @Override
            public void execute() {
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

    private static Command printAllPeople() {
        return new Command() {
            @Override
            public void execute() {
                for (Human hum : tree) {
                    System.out.println(hum);
                }
            }
        };
    }
}