package ru.mvp;

import ru.Command;
import ru.Human;

public interface View {
    void update();

    void setLoadCommand(Command command);

    void setCommandSave(Command command);

    void setFindChildren(Command command);

    void setPrintAllPeople(Command command);

    void setAddHuman(Command command);
    void setAboutHuman(Command command);
    void  printEror();
    String inputName();
    void printAllChild(Human human);

}
