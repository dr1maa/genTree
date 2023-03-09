package ru.mvp;

import ru.Command;

public interface View {
    void update();

    void setLoadCommand(Command command);

    void setCommandSave(Command command);

    void setFindChildren(Command command);

    void setPrintAllPeople(Command command);

    void setAddHuman(Command command);
    void setAboutHuman(Command command);

}
