package com.mpk.entities.card;

import com.mpk.entities.card.trait.Ring;
import com.mpk.entities.card.trait.Clan;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class ProvinceCard extends Card  {
    @Column
    private final int defense;
    @Column
    private final Ring ring;

    public ProvinceCard(String name, String description, Clan clan, int defense, Ring ring) {
        super(name, description, clan);
        this.defense = defense;
        this.ring = ring;
    }
}
