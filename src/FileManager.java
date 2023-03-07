import java.io.*;

public class FileManager implements Save {
    public void writeFile(Tree tree) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("person.out"));
        objectOutputStream.writeObject(tree);
        objectOutputStream.close();
    }

    public Tree readFile() throws IOException, ClassNotFoundException {
        ObjectInput objectInputStream = new ObjectInputStream(
                new FileInputStream("person.out"));
        TreeImple object1 = (TreeImple) objectInputStream.readObject();
        objectInputStream.close();
        return  object1;
    }

}
