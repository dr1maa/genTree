import java.util.Scanner;

public class ConsoleUi {
    public void printMenu(Command commandSave, Command commandLoad, Command findChildren, Command printAllPeople) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Список доступных команд: ");
        System.out.println("1 - сохранить файл");
        System.out.println("2 - загрузить из файла");
        System.out.println("3 - найти детей человека");
        System.out.println("4 - вывести всех людей");
        int number = scan.nextInt();
        if (number == 1) {
            commandSave.execute();
        } else {
            if (number == 2) {
                commandLoad.execute();
            } else {
                if (number == 3) {
                    findChildren.execute();
                } else if (number == 4) {
                    printAllPeople.execute();
                } else {
                    System.out.println("Что то пошло не так");
                }

            }
        }
    }
}
