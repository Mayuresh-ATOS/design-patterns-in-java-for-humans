package com.pmareke;

public class Sheep implements Cloneable {
    protected String name;
    protected String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Sheep(String name, String category) {
        this.name = name;
        this.category = this.category == null ? "Mountain Sheep" : category;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Sheep sheep;
        try {
            sheep = (Sheep) super.clone();
        } catch (CloneNotSupportedException e) { // this should never happen
            System.out.println("CloneNotSupportedException thrown " + e);
            return null;
        }
        return sheep;
    }
}
