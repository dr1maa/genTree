package ru.mvp;
import ru.Command;
import ru.Human;

import java.util.Scanner;
public class ConsoleUi implements View {

    private Command commandSave;
    private Command commandLoad;
    private Command findChildren;
    private Command printAllPeople;
    private Command addHuman;
    private Command aboutHuman;


    @Override
    public void update() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Список доступных команд: ");
        System.out.println("1 - сохранить файл");
        System.out.println("2 - загрузить из файла");
        System.out.println("3 - найти детей человека");
        System.out.println("4 - вывести всех людей");
        System.out.println("5 - Добавить нового человека");
        System.out.println("6 - Информация о человеке");
        int number = scan.nextInt();
        if (number == 1) {
            commandSave.execute();
        } else if (number == 2) {
            commandLoad.execute();
        } else if (number == 3) {
            findChildren.execute();
        } else if (number == 4) {
            printAllPeople.execute();
        } else if (number ==5){
            addHuman.execute();
        }else if (number ==6){
            aboutHuman.execute();
        }else{
            System.out.println("Что то пошло не так");
        }


    }

    @Override
    public void setLoadCommand(Command loadCommand) {
        this.commandLoad = loadCommand;
    }

    public void setCommandSave(Command commandSave) {
        this.commandSave = commandSave;
    }

    public void setFindChildren(Command findChildren) {
        this.findChildren = findChildren;
    }

    public void setPrintAllPeople(Command printAllPeople) {
        this.printAllPeople = printAllPeople;
    }
    public void setAddHuman(Command addHuman){
        this.addHuman = addHuman;
    }
    public void setAboutHuman(Command aboutHuman){
        this.aboutHuman = aboutHuman;
    }

    @Override
    public void printEror() {
        System.out.println("Дерево не загружено");
    }

    @Override
    public String inputName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя  Sveta , Anatoliy, Lena, Enakentiy, Anastasia, Aleksandr, Alexey");
        String name = scanner.nextLine();
        return name;
    }

    @Override
    public void printAllChild(Human result) {
        System.out.println("Все дети " + result + " : ");
        for (Human hum : result.getChildren()) {
            System.out.println(hum.getName());
        }

    }


}
