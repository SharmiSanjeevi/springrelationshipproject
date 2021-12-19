package com.gamestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Game {
    @Id
    @Column(name = "gameid")
    @GeneratedValue(generator = "game_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "game_seq", sequenceName = "game_sequence", initialValue = 1, allocationSize = 1)
    private Integer gameId;

    @Column(length = 20)
    private String name;

    @Column(nullable = false)
    private double rating;

    @Column(nullable = false)
    private int downloads;

    @Column(length = 20)
    private String size;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requirementid")
    Requirement requirement;

    @ManyToOne
    @JoinColumn(name = "publisherid")
//    @JsonIgnore
    private Publisher publisher;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "game_category",
            joinColumns = @JoinColumn(name = "gameid"),
            inverseJoinColumns = @JoinColumn(name = "categoryid")
    )
    private Set<Category> categories;

    public Game(String name, double rating, int downloads, String size, Requirement requirement, Publisher publisher, Set<Category> categories) {
        this.name = name;
        this.rating = rating;
        this.downloads = downloads;
        this.size = size;
        this.requirement = requirement;
        this.publisher = publisher;
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", downloads=" + downloads +
                ", size='" + size + '\'' +
                ", requirement=" + requirement +
                ", publisher=" + publisher +
                ", categories=" + categories +
                '}';
    }
}
