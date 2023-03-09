package org.training.controller;

public interface FileController {

    void printAllFiles();
    void printFilteredFilesByName(String query);

    void printFilteredLinesFromFile(Integer fileNumber, String query);

    void printWholeFile(Integer subSelection);

    Integer fileCount();
}
