package io.github.itstaylz.hexlib.storage.files;

import java.io.File;
import java.io.IOException;

abstract class FileBase {

    private final File file;

    public FileBase(File file) {
        this.file = file;
    }

    public boolean deleteFile() {
        return this.file.delete();
    }

    public boolean createFile() {
        try {
            return this.file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean fileExists() {
        return this.file.exists();
    }

    public File getFile() {
        return file;
    }
}
