package org.training.repository;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.training.constants.Constants.FILE_SOURCE_PATH;

public class FileRepositoryImpl implements FileRepository {
    private List<File> fileList;

    public FileRepositoryImpl() {
        setFileList();
    }

    @Override
    public List<File> getFileList() {
        return fileList;
    }

    private void setFileList() {
        try {
            this.fileList = Arrays.stream(Objects.requireNonNull(new File(FILE_SOURCE_PATH).listFiles())).toList();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<File> filterFilesByName(String query) {
        return fileList.stream().filter(file -> file.getName().contains(query)).toList();
    }

    @Override
    public File selectFileById(Integer num) {
        return fileList.get(num - 1);
    }
}
