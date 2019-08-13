package com.pmareke.models;

abstract public class Builder {

    // Template method
    public void build() {
        this.Test();
        this.Lint();
        this.Assemble();
        this.Deploy();
    }

    abstract public void Test();

    abstract public void Lint();

    abstract public void Assemble();

    abstract public void Deploy();
}
