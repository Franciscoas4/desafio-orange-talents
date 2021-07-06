package com.orange.marvelapi.dto;

import java.util.List;

public class ListCreatorDTO {

    private Integer available;
    private Integer returned;
    private String collectionURI;
    private List<SummaryCreatorsDTO> items;

    public ListCreatorDTO(Integer available, Integer returned, String collectionURI, List<SummaryCreatorsDTO> items) {
        this.available = available;
        this.returned = returned;
        this.collectionURI = collectionURI;
        this.items = items;
    }

    public Integer getAvailable() {
        return available;
    }

    public Integer getReturned() {
        return returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public List<SummaryCreatorsDTO> getItems() {
        return items;
    }
}
