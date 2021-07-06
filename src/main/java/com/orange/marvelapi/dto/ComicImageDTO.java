package com.orange.marvelapi.dto;

public class ComicImageDTO {

    private String path;
    private String extension;

    public ComicImageDTO(String path, String extension) {
        this.path = path;
        this.extension = extension;
    }

    public String getPath() {
        return path;
    }

    public String getExtension() {
        return extension;
    }
}
