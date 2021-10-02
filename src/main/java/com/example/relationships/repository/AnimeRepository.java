package com.example.relationships.repository;

import com.example.relationships.entity.Anime;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {

    Page <Anime> findByCountryContaining(String name, Pageable pageable);
}
