import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

//нужен еще класс дерева,
// который бы хранил коллекцию людей и делал операции над ней,
// например мог добавлять новых людей в семью, искать человека по имени
public class TreeImple implements Tree, Serializable, FamilyIterator {
    private Human root;
    private ArrayList<Human> familyList = new ArrayList<>();

    public TreeImple(String name, Gender gender) {
        this.root = new Human(name, gender);
        familyList.add(root);
    }

    @Override
    public void addChild(String name, Gender childGender, String motherName, String fatherName) {
        Human child = new Human(name, childGender);
        Human mother = findPeople(motherName);
        Human father = findPeople(fatherName);
        relations(child, mother, father);
        familyList.add(child);

    }

    @Override
    public void addParants(String name, String motherName, String fatherName) {
        Human people = findPeople(name);
        Human mother = new Human(motherName, Gender.WOMAN);
        Human father = new Human(fatherName, Gender.MAN);
        relations(people, mother, father);
        familyList.add(mother);
        familyList.add(father);
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

    private class FamilyIterator implements Iterator<Human> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < familyList.size();
        }

        @Override
        public Human next() {
            index = index + 1;
            return familyList.get(index);
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
        @Override
        public void forEachRemaining(Consumer action) {
            Iterator.super.forEachRemaining(action);
        }

    }

    public Iterator<Human> iterator() {
        return new FamilyIterator();
    }
}
