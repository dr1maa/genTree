package ru;

import java.util.List;

public interface Tree {
    Human addChild(String name, Gender childGender, String motherName, String fatherName);

    Human addChild();

    void addParents(String name, String motherName, String fatherName);

    Human findHuman(String name);
    List<Human> aboutPeople(Human human);
}
