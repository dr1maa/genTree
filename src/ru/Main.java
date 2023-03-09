package ru;
import ru.mvp.ConsoleUi;
import ru.mvp.Presenter;
public class Main {
    public static void main(String[] args) {
        Presenter p = new Presenter(new ConsoleUi());
        p.update();
    }
}