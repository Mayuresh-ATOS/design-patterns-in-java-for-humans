package com.pmareke;

public class BurgerBuilder {
    protected int size;
    protected Boolean cheese = false;
    protected Boolean pepperoni = false;
    protected Boolean lettuce = false;
    protected Boolean tomato = false;

    public BurgerBuilder(int size) {
        this.size = size;
    }

    public BurgerBuilder AddPepperoni() {
        this.pepperoni = true;
        return this;
    }

    public BurgerBuilder AddLettuce() {
        this.lettuce = true;
        return this;
    }

    public BurgerBuilder AddCheese() {
        this.cheese = true;
        return this;
    }

    public BurgerBuilder AddTomato() {
        this.tomato = true;
        return this;
    }

    public Burger Build() {
        return new Burger(this);
    }
}
