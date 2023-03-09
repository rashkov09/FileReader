package org.training.service;

import com.sun.source.tree.BreakTree;
import org.training.repository.FileRepository;
import org.training.repository.FileRepositoryImpl;

import java.io.*;
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
                    .append(i + 1)
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
                    .append(i + 1)
                    .append(". ")
                    .append(filteredFiles.get(i).getName())
                    .append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String searchInFileForLinesContaining(Integer fileNum, String query) {
        stringBuilder.setLength(0);
        File selectedFile = fileRepository.selectFileById(fileNum);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
            String line = reader.readLine();
            while (line != null) {
                if (line.contains(query)) {
                    stringBuilder.append(line).append("\n");
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    @Override
    public String getAllLinesInFile(Integer fileNum) {
        stringBuilder.setLength(0);
        File selectedFile = fileRepository.selectFileById(fileNum);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(selectedFile));
            String line = reader.readLine();
            while (line != null) {
                    stringBuilder.append(line).append("\n");
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    @Override
    public Integer getFileCount() {
        return fileRepository.getFileList().size();
    }
}
