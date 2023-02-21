import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Human meTree = initMe();
        System.out.println("Введите имя  Sveta , Anatoliy, Lena, Enakentiy, Anastasia, Aleksandr");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Human result = findPeople(name, meTree);
        System.out.println("Все дети " + result.getName() + " : ");
        for (Human hum : result.getChild()) {
            System.out.println(hum.getName());
        }

    }

    private static Human initMe() {
        Human mother = new Human("Sveta", Gender.WOMAN);
        Human father = new Human("Anatoliy", Gender.MAN);
        Human grandMotherM = new Human("Lena", Gender.WOMAN);
        Human grandFatherM = new Human("Enakentiy", Gender.MAN);
        Human grandFatherF = new Human("Anastasia", Gender.WOMAN);
        Human grandMotherF = new Human("Aleksandr", Gender.MAN);
        Human me = new Human("Ivan", Gender.MAN);
        Human brother = new Human("Andew", Gender.MAN);
        setParants(me, mother, father);
        setParants(mother, grandMotherM, grandFatherM);
        setParants(father, grandFatherF, grandMotherF);
        setParants(brother, mother, father);
        return me;
    }

    private static void setParants(Human target, Human mom, Human dad) {
        target.setMom(mom);
        target.setDad(dad);
        mom.addChild(target);
        dad.addChild(target);
    }

    private static Human findPeople(String name, Human target) {
        if (target.getName().equals(name)) {
            return target;
        }
        if (target.getMom() != null) {
            Human resMom = findPeople(name, target.getMom());
            if (resMom != null) {
                return resMom;
            }
        }
        if (target.getDad() != null) {
            Human resDad = findPeople(name, target.getDad());
            if (resDad != null) {
                return resDad;
            }
        }
        return null;
    }


}