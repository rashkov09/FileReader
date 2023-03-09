package org.training.service;

public interface FileService {

    String listOfFiles();
    String filteredListByName(String query);
    String searchInFileForLinesContaining(Integer fileNum, String query);

    String getAllLinesInFile(Integer fileNum);

    Integer getFileCount();
}
