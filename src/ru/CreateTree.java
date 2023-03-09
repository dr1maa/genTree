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


    public T getRoot() {
        return root;
    }

    public Iterator<T> iterator() {
        return new FamilyIterator<>(familyList);
    }

}
