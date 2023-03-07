import java.io.Serializable;
import java.util.Iterator;

public class TreeImple implements Tree, Serializable, Iterable<Human> {
    private NewTreeParam<Human> humanTree;

    public TreeImple(String name, Gender gender) {
        Human me = new Human("Alexey", Gender.MAN);
        humanTree = new NewTreeParam<>(me);
    }
    @Override
    public void addChild(String name, Gender childGender, String motherName, String fatherName) {
        Human child = new Human(name, childGender);
        Human mother = findHuman(motherName);
        Human father = findHuman(fatherName);
        relations(child, mother, father);
        humanTree.addChild(child);

    }

    @Override
    public void addParents(String name, String motherName, String fatherName) {
        Human people = findHuman(name);
        Human mother = new Human(motherName, Gender.WOMAN);
        Human father = new Human(fatherName, Gender.MAN);
        relations(people, mother, father);
        humanTree.addParants(mother, father);
    }

    private void relations(Human child, Human mother, Human father) {
        child.setMom(mother);
        child.setDad(father);
        mother.getChildren().add(child);
        father.getChildren().add(child);
    }

    @Override
    public Human findHuman(String name) {
        Human root = humanTree.getRoot();
        return findParents(name, root);
    }

    private static Human findParents(String name, Human target) {
        if (target.getName().equals(name)) {
            return target;
        }
        if (target.getMom() != null) {
            Human resMom = findParents(name, target.getMom());
            if (resMom != null) {
                return resMom;
            }
        }
        if (target.getDad() != null) {
            Human resDad = findParents(name, target.getDad());
            if (resDad != null) {
                return resDad;
            }
        }
        return null;
    }


    public Iterator<Human> iterator() {
        return humanTree.iterator();
    }
}
