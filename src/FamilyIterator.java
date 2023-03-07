import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class FamilyIterator<T> implements Iterator<T> {
    private ArrayList<T> familyList;


    private int index = 0;

    public FamilyIterator(ArrayList<T> familyList) {
        this.familyList = familyList;
    }

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
