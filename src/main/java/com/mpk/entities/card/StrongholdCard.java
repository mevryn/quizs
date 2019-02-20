package com.mpk.entities.card;

import com.mpk.entities.card.trait.Clan;
import com.mpk.entities.card.trait.LocationTrait;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class StrongholdCard extends Card {
    @Column
    private final LocationTrait locationTrait;
    @Column
    private final int addDefense;
    @Column
    private final int startHonor;
    @Column
    private final int fateValue;

    public StrongholdCard(String name, String description, Clan clan, LocationTrait locationTrait, int addDefense, int startHonor, int fateValue) {
        super(name, description, clan);
        this.locationTrait = locationTrait;
        this.addDefense = addDefense;
        this.startHonor = startHonor;
        this.fateValue = fateValue;
    }
}
