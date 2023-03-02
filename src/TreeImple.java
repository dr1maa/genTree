import java.io.Serializable;

//нужен еще класс дерева,
// который бы хранил коллекцию людей и делал операции над ней,
// например мог добавлять новых людей в семью, искать человека по имени
public class TreeImple implements Tree, Serializable {
    private Human root;

    public TreeImple(String name, Gender gender) {
        this.root = new Human(name, gender);
    }

    @Override
    public void addChild(String name, Gender childGender, String motherName, String fatherName) {
        Human child = new Human(name, childGender);
        Human mother = findPeople(motherName);
        Human father = findPeople(fatherName);
        relations(child, mother, father);

    }

    @Override
    public void addParants(String name, String motherName, String fatherName) {
        Human people = findPeople(name);
        Human mother = new Human(motherName, Gender.WOMAN);
        Human father = new Human(fatherName, Gender.MAN);
        relations(people, mother, father);
    }

    private void relations(Human child, Human mother, Human father) {
        child.setMom(mother);
        child.setDad(father);
        mother.getChildren().add(child);
        father.getChildren().add(child);
    }

    @Override
    public Human findPeople(String name) {
        return findPerents(name, root);
    }

    private static Human findPerents(String name, Human target) {
        if (target.getName().equals(name)) {
            return target;
        }
        if (target.getMom() != null) {
            Human resMom = findPerents(name, target.getMom());
            if (resMom != null) {
                return resMom;
            }
        }
        if (target.getDad() != null) {
            Human resDad = findPerents(name, target.getDad());
            if (resDad != null) {
                return resDad;
            }
        }
        return null;
    }
}
