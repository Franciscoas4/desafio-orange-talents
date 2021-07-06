package com.orange.marvelapi.dto;

import java.util.List;

public class MarvelComicDTO {

    private Long id;
    private Long digitalId;
    private String title;
    private String description;
    private String isbn;
    private List<PriceComicDTO> prices;
    private ComicImageDTO thumbnail;
    private ListCreatorDTO creators;
    private List<SummaryCreatorsDTO> items;

    public MarvelComicDTO(Long id, Long digitalId, String title, String description, String isbn, List<PriceComicDTO> prices, ComicImageDTO thumbnail, ListCreatorDTO creators, List<SummaryCreatorsDTO> items) {
        this.id = id;
        this.digitalId = digitalId;
        this.title = title;
        this.description = description;
        this.isbn = isbn;
        this.prices = prices;
        this.thumbnail = thumbnail;
        this.creators = creators;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public Long getDigitalId() {
        return digitalId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getIsbn() {
        return isbn;
    }

    public List<PriceComicDTO> getPrices() {
        return prices;
    }

    public ComicImageDTO getThumbnail() {
        return thumbnail;
    }

    public ListCreatorDTO getCreators() {
        return creators;
    }

    public List<SummaryCreatorsDTO> getItems() {
        return items;
    }
}
