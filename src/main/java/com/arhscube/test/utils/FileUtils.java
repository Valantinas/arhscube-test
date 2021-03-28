package com.arhscube.test.utils;

import java.io.InputStream;

public class FileUtils {

    private FileUtils() {
    }

    public static InputStream read(String fileName) {
        return FileUtils.class.getClassLoader().getResourceAsStream(fileName);
    }

}