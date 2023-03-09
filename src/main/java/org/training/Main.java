package org.training;

import org.training.controller.FileController;
import org.training.controller.FileControllerImpl;

import java.util.Scanner;

import static org.training.constants.Constants.*;

public class Main {
   private final static Scanner scanner = new Scanner(System.in);
   private final static FileController fileController = new FileControllerImpl();
    public static void main(String[] args) {

        System.out.print(START_SCREEN_INSTRUCTIONS);
        System.out.print(OPTION_SELECTION);

        int selection = scanner.nextInt();
        while (selection != 0){
            switch (selection) {
                case 1 -> printAllFiles();
                case 2 -> searchForFileByName();
                case 3 -> printFileContent();
                default -> {
                    return;
                }
            }
            selection = scanner.nextInt();
        }
    }

    private static void printFileContent() {
        fileController.printAllFiles();
        System.out.print(OPTION_SELECTION);
        int fileNum = scanner.nextInt();
        System.out.print(QUERY_INSERTION);
        String query = scanner.nextLine();
        while (query.isEmpty()) {
          query=scanner.nextLine();
        }
        fileController.printFilteredLinesFromFile(fileNum, query);
        System.out.println(GO_BACK);
        int back = scanner.nextInt();
        while (back != 0){
            back = scanner.nextInt();
        }

    }

    private static void searchForFileByName() {
        System.out.println(QUERY_INSERTION);
        String query = scanner.nextLine();
        while (query.isEmpty()){
            query=scanner.nextLine();
        }
        fileController.printFilteredFilesByName(query);
    }

    private static void printAllFiles() {
        fileController.printAllFiles();
        System.out.println(GO_BACK);
        System.out.println(OPTION_SELECTION_READ_FILE);
        int subSelection = scanner.nextInt();
        while( subSelection != 0){
            switch (subSelection) {
                case 1, 2, 3 -> {
                    fileController.printWholeFile(subSelection);
                    System.out.println(GO_BACK);
                }
            }
           subSelection = scanner.nextInt();
        }
        System.out.print(START_SCREEN_INSTRUCTIONS);
    }
}