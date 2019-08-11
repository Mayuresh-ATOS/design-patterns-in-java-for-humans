package com.pmareke;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep original = new Sheep("Jolly", null);

        // Clone and modify what is required
        Sheep cloned = (Sheep) original.clone();
        cloned.setName("Dolly");
        cloned.setCategory("Cloned Sheep");

        System.out.println(original.getName()); // Jolly
        System.out.println(original.getCategory()); // Mountain Sheep

        System.out.println(cloned.getName()); // Dolly
        System.out.println(cloned.getCategory()); // Mountain sheep
    }
}
