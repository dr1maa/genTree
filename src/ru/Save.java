package ru;

import java.io.IOException;

public interface Save  {
    void writeFile(Tree tree) throws IOException;
    Tree readFile() throws IOException, ClassNotFoundException;
}
