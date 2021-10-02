package com.example.relationships.entity.oneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    /*
    *  Bidirectional
    * */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long authorId;
    private String name;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> book;
}
