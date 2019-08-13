package com.pmareke.models;

public class AndroidBuilder extends Builder {
    @Override
    public void Test() {
        System.out.println("Running android tests");
    }

    @Override
    public void Lint() {
        System.out.println("Linting the android code");
    }

    @Override
    public void Assemble() {
        System.out.println("Assembling the android build");
    }

    @Override
    public void Deploy() {
        System.out.println("Deploying android build to server");
    }
}
