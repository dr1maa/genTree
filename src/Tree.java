public interface Tree {
    void addChild(String name, Gender childGender, String motherName, String fatherName);

    void addParents(String name, String motherName, String fatherName);

    Human findHuman(String name);
}
