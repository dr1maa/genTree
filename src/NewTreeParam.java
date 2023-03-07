import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class NewTreeParam<T> implements Serializable {
    private T root;
    private ArrayList<T> familyList = new ArrayList<>();


    public NewTreeParam(T root) {
        this.root = root;
        familyList.add(root);

    }

    public void addChild(T child) {
        familyList.add(child);
    }

    public void addParants(T mother, T father) {
        familyList.add(mother);
        familyList.add(father);

    }


    public T findPeople(String name) {
        return null;
    }

    private class FamilyIterator implements Iterator<T> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < familyList.size();
        }

        @Override
        public T next() {
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

    public T getRoot() {
        return root;
    }

    public Iterator<T> iterator() {
        return new NewTreeParam.FamilyIterator();
    }

}
