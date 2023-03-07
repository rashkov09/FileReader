package org.training.service;

import org.training.repository.FileRepository;
import org.training.repository.FileRepositoryImpl;

import java.io.File;
import java.util.List;

public class FileServiceImpl implements FileService {
    private final FileRepository fileRepository;
    private final StringBuilder stringBuilder;

    public FileServiceImpl() {
        this.stringBuilder = new StringBuilder();
        fileRepository = new FileRepositoryImpl();
    }


    @Override
    public String listOfFiles() {
        stringBuilder.setLength(0);
        for (int i = 0; i < fileRepository.getFileList().size(); i++) {
            stringBuilder
                    .append(i+1)
                    .append(". ")
                    .append(fileRepository.getFileList().get(i).getName())
                    .append("\n");
        }
       return stringBuilder.toString();
    }

    @Override
    public String filteredListByName(String query) {
        stringBuilder.setLength(0);
        List<File> filteredFiles = fileRepository.filterFilesByName(query);
        for (int i = 0; i < filteredFiles.size(); i++) {
            stringBuilder
                    .append(i+1)
                    .append(". ")
                    .append(filteredFiles.get(i).getName())
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
