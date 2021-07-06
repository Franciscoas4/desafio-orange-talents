package com.orange.marvelapi.repository;

import com.orange.marvelapi.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComicRepository extends JpaRepository<Comic, Long> {

    Optional<Comic> findByComicId(Long comicId);
}
