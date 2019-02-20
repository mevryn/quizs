package com.mpk.entities.card;

import com.mpk.entities.card.trait.Clan;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class Card implements Serializable {
    @Column
    protected String name;
    @Column
    protected String description;
    @Column
    protected Clan clan;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;
    protected Card(){

    }
    protected Card(String name, String description, Clan clan) {
        this.name = name;
        this.description = description;
        this.clan = clan;
    }
}
