package ru;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class CreateTree<T> implements Serializable {
    private T root;
    private ArrayList<T> familyList = new ArrayList<>();


    public CreateTree(T root) {
        this.root = root;
        familyList.add(root);

    }

    public void addHumanToFamily(T human) {
        familyList.add(human);
    }

    public T getRoot() {
        return root;
    }

    public Iterator<T> iterator() {
        return new FamilyIterator<>(familyList);
    }

}
