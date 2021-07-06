package com.orange.marvelapi.dto;

public class SummaryCreatorsDTO {

    private String resourceURI;
    private String name;
    private String role;

    public SummaryCreatorsDTO(String resourceURI, String name, String role) {
        this.resourceURI = resourceURI;
        this.name = name;
        this.role = role;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
