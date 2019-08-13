package com.pmareke.models;

public class IosBuilder extends Builder {
    @Override
    public void Test() {
        System.out.println("Running ios tests");
    }

    @Override
    public void Lint() {
        System.out.println("Linting the ios code");
    }

    @Override
    public void Assemble() {
        System.out.println("Assembling the ios build");
    }

    @Override
    public void Deploy() {
        System.out.println("Deploying ios build to server");
    }
}
