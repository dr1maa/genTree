import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("хотите создать файл ? введите 1");
        System.out.println("хотите прочитать из файла ? введите 2");

        String numberStr = scanner.nextLine();
        FileManager save = new FileManager();
        Tree tree = null;
        if (numberStr.equals("1")) {
            tree = initTre();
            save.writeFile(tree);
        } else if (numberStr.equals("2")) {
            tree = save.readFile();
        }
        System.out.println("Введите имя  Sveta , Anatoliy, Lena, Enakentiy, Anastasia, Aleksandr, Alexey");
        String name = scanner.nextLine();
        Human result = tree.findPeople(name);
        System.out.println("Все дети " + result + " : ");
        for (Human hum : result.getChildren()) {
            System.out.println(hum.getName());
        }
    }

    private static Tree initTre() {
        Tree tree = new TreeImple("Alexey", Gender.MAN);
        tree.addParants("Alexey", "Sveta", "Anatoliy");
        tree.addParants("Sveta", "Lena", "Enakentiy");
        tree.addParants("Anatoliy", "Anastasia", "Aleksandr");
        tree.addChild("Andrew", Gender.MAN, "Sveta", "Anatoliy");
        return tree;
    }

}