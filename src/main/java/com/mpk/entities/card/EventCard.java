package com.mpk.entities.card;

import com.mpk.entities.card.trait.Clan;
import com.mpk.entities.card.trait.OtherTrait;
import com.mpk.entities.card.trait.Ring;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Set;

@Entity
public class EventCard extends Card {
    @ElementCollection(fetch = FetchType.EAGER)
    private final Set<OtherTrait> otherTraitSet;
    private final Ring ring;
    private final int fateCost;

    public EventCard(String name, String description, Clan clan, Set<OtherTrait> otherTraitSet, Ring ring, int fateCost) {
        super(name, description, clan);
        this.otherTraitSet = otherTraitSet;
        this.ring = ring;
        this.fateCost = fateCost;
    }
}
