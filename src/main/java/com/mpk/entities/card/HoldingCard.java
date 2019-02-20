package com.mpk.entities.card;

import com.mpk.entities.card.trait.Clan;
import com.mpk.entities.card.trait.LocationTrait;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class HoldingCard extends Card {
    @Column
    private final int defAdd;
    @Column
    private final LocationTrait locationTrait;

    public HoldingCard(String name, String description, Clan clan, int defAdd, LocationTrait locationTrait) {
        super(name, description, clan);
        this.defAdd = defAdd;
        this.locationTrait = locationTrait;
    }
}
