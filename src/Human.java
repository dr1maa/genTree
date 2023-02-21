import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private Human mom;
    private Human dad;

    private List<Human> child;
    private Gender gender;

    public Human(String name, Gender gender) {
        this.name = name;
        this.gender = gender;
        this.child = new ArrayList<>();
    }
    public void addChild(Human child){
     this.child.add(child);
    }

    public List<Human> getChild() {
        return child;
    }

    public void setChild(List<Human> child) {
        this.child = child;
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
        return "Human{" +
                "name='" + name + '\'' +
                '}';
    }
}
