package com.example.relationships.paging;

import com.example.relationships.entity.Anime;
import com.example.relationships.repository.AnimeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class AnimeRepositoryTest {

    @Autowired
    private AnimeRepository animeRepository;

    /*
    *   PAGING
    */

    @Test
    public void findAllPagination() {
        Pageable fistPage5Records = PageRequest.of(0, 6);
        Pageable secondPage5Records = PageRequest.of(1, 5);

        List<Anime> animes = animeRepository.findAll(fistPage5Records).getContent();

        long totalElements = animeRepository.findAll(fistPage5Records).getTotalElements();
        long totalPages = animeRepository.findAll(fistPage5Records).getTotalPages();

        System.out.println("[ List -> " + animes);
        System.out.println("[ Total elements -> " + totalElements);
        System.out.println("[ Total pages    -> " + totalPages);
    }

    @Test
    public void findAllSorting() {
        Pageable sortByName = PageRequest.of(0,2, Sort.by("name") );
        Pageable sortByCountry = PageRequest.of(0,3,Sort.by("country").descending().and(Sort.by("name")));

        List<Anime> animes = animeRepository.findAll(sortByName).getContent();

        System.out.println("-Animes----> " + animes);
    }

    @Test
    public void printFindByCountryContaining() {
        Pageable firstPage = PageRequest.of(0,4);

        List<Anime> animes = animeRepository.findByCountryContaining("China", firstPage).getContent();

        System.out.println("-Country--> " + animes);
    }
}
