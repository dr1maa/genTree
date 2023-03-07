public interface Tree {
    void addChild(String name, Gender childGender, String motherName, String fatherName);

    void addParants(String name, String motherName, String fatherName);

    Human findPeople(String name);
}
