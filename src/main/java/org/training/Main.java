package org.training;

import org.training.controller.FileControllerImpl;

public class Main {
    public static void main(String[] args) {
        FileControllerImpl fileController = new FileControllerImpl();
        fileController.printAllFiles();

        fileController.printFilteredFilesByName("one");

        fileController.printFilteredFilesByName("two");

        fileController.printFilteredFilesByName("_");






    }
}