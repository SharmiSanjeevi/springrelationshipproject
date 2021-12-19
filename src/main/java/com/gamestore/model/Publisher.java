package com.gamestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Publisher {

    @Id
    @Column(name = "publisherid")
    @GeneratedValue(generator = "publisher_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "publisher_seq", sequenceName = "publisher_sequenece", allocationSize = 1)
    private Integer publisherId;

    @Column(length = 30)
    private String publisherName;

    @Column(length = 20)
    private String country;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "publisherid")
    @JsonIgnore
    private Set<Game> games;

    public Publisher(String publisherName, String country) {
        this.publisherName = publisherName;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "publisherId=" + publisherId +
                ", publisherName='" + publisherName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
