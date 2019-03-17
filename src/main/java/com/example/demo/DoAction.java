package com.example.demo;


import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;

public class DoAction {
    private double match = 0.8;

    public void getFile() throws IOException {
        File file = ResourceUtils.getFile("classPath:templates");
        if (file.exists()) {
            System.out.print(file.getName());
        }
    }
}
