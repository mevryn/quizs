package com.mpk.entities.card;

import com.mpk.entities.card.trait.Clan;
import com.mpk.entities.card.trait.OtherTrait;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Set;

@Entity
public class AttachmentCard extends Card {
    @Column
    private final int fateCost;
    @Column
    private final int politicalAdd;
    @Column
    private final int militaryAdd;
    @ElementCollection(fetch = FetchType.EAGER)
    private final Set<OtherTrait> otherTraits;

    public AttachmentCard(String name, String description, Clan clan, int fateCost, int politicalAdd, int militaryAdd, Set<OtherTrait> otherTraits) {
        super(name, description, clan);
        this.fateCost = fateCost;
        this.politicalAdd = politicalAdd;
        this.militaryAdd = militaryAdd;
        this.otherTraits = otherTraits;
    }
}
