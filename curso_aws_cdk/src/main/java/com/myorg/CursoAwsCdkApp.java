package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class CursoAwsCdkApp {
    public static void main(final String[] args) {
        App app = new App();

        new CursoAwsCdkStack(app, "CursoAwsCdkStack", StackProps.builder()
                .build());

        app.synth();
    }
}

