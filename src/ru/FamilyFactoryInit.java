package ru;

public class FamilyFactoryInit {
    public static TreeImple initTree() {
        TreeImple tree = new TreeImple("Alexey", Gender.MAN);
        tree.addParents("Alexey", "Sveta", "Anatoliy");
        tree.addParents("Sveta", "Lena", "Enakentiy");
        tree.addParents("Anatoliy", "Anastasia", "Aleksandr");
        tree.addChild("Andrew", Gender.MAN, "Sveta", "Anatoliy");
        return tree;
    }

}
