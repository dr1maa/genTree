package ru;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private Human mom;
    private Human dad;

    private List<Human> children;
    private Gender gender;

    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human getMom() {
        return mom;
    }

    public void setMom(Human mom) {
        this.mom = mom;
    }

    public Human getDad() {
        return dad;
    }

    public void setDad(Human dad) {
        this.dad = dad;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }


    @Override
    public String toString() {
        return "ru.Human{" +
                "name='" + name + '\'' +
                '}';
    }
}
