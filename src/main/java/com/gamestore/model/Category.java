package com.gamestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @Column(name = "categoryid")
    @GeneratedValue(generator = "category_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "category_seq", sequenceName = "category_sequence", initialValue = 1, allocationSize = 1)
    private Integer categoryId;


    @Enumerated(EnumType.STRING)
    private CategoryName name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "categories")
    @JsonIgnore
    private Set<Game> game;

    public Category(CategoryName name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name=" + name +
                '}';
    }
}
