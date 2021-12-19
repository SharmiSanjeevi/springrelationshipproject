package com.gamestore.model;

import lombok.*;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Requirement {


    @Id
    @Column(name = "requirementid")
    @GeneratedValue(generator = "req_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "req_seq", sequenceName = "requirement_sequence", initialValue = 1, allocationSize = 1)
    private Integer requirementId;

    @Column(name = "requiredram", length = 20)
    private String requiredRAM;

    @Column(name = "requiredstorage", length = 20)
    private String requiredStorage;



    public Requirement(String requiredRAM, String requiredStorage) {
        this.requiredRAM = requiredRAM;
        this.requiredStorage = requiredStorage;
    }
}
