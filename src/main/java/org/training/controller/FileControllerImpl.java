package org.training.controller;


import org.training.service.FileService;
import org.training.service.FileServiceImpl;

public class FileControllerImpl implements FileController {
    private final FileService fileService;

    public FileControllerImpl() {
        this.fileService = new FileServiceImpl();
    }


    @Override
    public void printAllFiles() {
        System.out.println(fileService.listOfFiles());
    }

    @Override
    public void printFilteredFilesByName(String query) {
        System.out.println(fileService.filteredListByName(query));
    }
}
