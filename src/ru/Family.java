package ru;

import java.util.ArrayList;
import java.util.List;

public class Family<T> {
    private T mother;
    private T father;
    private List<T> children = new ArrayList<>();

    public Family(T mother, T father) {
        this.mother = mother;
        this.father = father;
    }

    public void addChild(T child) {
        children.add(child);
    }

    public void addParents(T mother, T father) {
        this.mother = mother;
        this.father = father;
    }

    public T getMother() {
        return mother;
    }

    public void setMother(T mother) {
        this.mother = mother;
    }

    public T getFather() {
        return father;
    }

    public void setFather(T father) {
        this.father = father;
    }

    public List<T> getChildren() {
        return children;
    }

    public void setChildren(List<T> children) {
        this.children = children;
    }
}
