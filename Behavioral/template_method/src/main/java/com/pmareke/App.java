package com.pmareke;

import com.pmareke.models.AndroidBuilder;
import com.pmareke.models.IosBuilder;

public class App {
    public static void main(String[] args) {
        AndroidBuilder androidBuilder = new AndroidBuilder();
        androidBuilder.build();

        // Output:
        // Running android tests
        // Linting the android code
        // Assembling the android build
        // Deploying android build to server

        IosBuilder iosBuilder = new IosBuilder();
        iosBuilder.build();

        // Output:
        // Running ios tests
        // Linting the ios code
        // Assembling the ios build
        // Deploying ios build to server
    }
}
