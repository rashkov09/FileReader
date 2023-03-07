package org.training.repository;

import java.io.File;
import java.util.List;

public interface FileRepository {
    List<File> getFileList();
    List<File> filterFilesByName(String query);
    File selectFileById(Integer num);
}
