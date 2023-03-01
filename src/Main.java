import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tree tree = initTre();
        System.out.println("Введите имя  Sveta , Anatoliy, Lena, Enakentiy, Anastasia, Aleksandr, Alexey");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Human result = tree.findPeople(name);
        System.out.println("Все дети " + result + " : ");
        for (Human hum : result.getChildren()) {
            System.out.println(hum.getName());
        }
    }

    private static Tree initTre() {
        Tree tree = new Tree("Alexey", Gender.MAN);
        tree.addParants("Alexey", "Sveta", "Anatoliy");
        tree.addParants("Sveta", "Lena", "Enakentiy");
        tree.addParants("Anatoliy", "Anastasia", "Aleksandr");
        tree.addChild("Andrew", Gender.MAN, "Sveta","Anatoliy");
        return tree;
    }

}