package com.example.mockito;

public class FileService {

    private FileReader reader;
    private FileWriter writer;

    public FileService(FileReader reader, FileWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public String processFile() {
        String data = reader.read();
        writer.write(data);
        return "Processed " + data;
    }
}