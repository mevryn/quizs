package com.mpk.entities.card;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.mpk.entities.card.trait.Clan;
import com.mpk.entities.card.trait.PersonTrait;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,
        property="refId", scope=CharacterCard.class)
public class CharacterCard{
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
    @Column
    private Integer fateCost;
    @Column
    private Integer militarySkill;
    @Column
    private Integer politicalSkill;
    @Column
    private Integer glory;
    @Column
    private String quotation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Integer getId() {
        return id;
    }

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<PersonTrait> personTraits;
    @Column
    private Boolean conflictCard;
    public CharacterCard(){
        }

    public CharacterCard(String name, String description, Clan clan, Integer fateCost, Integer militarySkill, Integer politicalSkill, Integer glory, String quotation, Set<PersonTrait> personTraits, Boolean conflictCard) {
        this.name = name;
        this.description = description;
        this.clan=clan;

        this.fateCost = fateCost;
        this.militarySkill = militarySkill;
        this.politicalSkill = politicalSkill;
        this.glory = glory;
        this.quotation = quotation;
        this.personTraits = personTraits;
        this.conflictCard = conflictCard;
    }

    public Integer getFateCost() {
        return fateCost;
    }

    public void setFateCost(Integer fateCost) {
        this.fateCost = fateCost;
    }

    public Integer getMilitarySkill() {
        return militarySkill;
    }

    public void setMilitarySkill(Integer militarySkill) {
        this.militarySkill = militarySkill;
    }

    public Integer getPoliticalSkill() {
        return politicalSkill;
    }

    public void setPoliticalSkill(Integer politicalSkill) {
        this.politicalSkill = politicalSkill;
    }

    public Integer getGlory() {
        return glory;
    }

    public void setGlory(Integer glory) {
        this.glory = glory;
    }

    public String getQuotation() {
        return quotation;
    }

    public void setQuotation(String quotation) {
        this.quotation = quotation;
    }

    public Set<PersonTrait> getPersonTraits() {
        return personTraits;
    }

    public void setPersonTraits(Set<PersonTrait> personTraits) {
        this.personTraits = personTraits;
    }

    public Boolean getConflictCard() {
        return conflictCard;
    }

    public void setConflictCard(Boolean conflictCard) {
        this.conflictCard = conflictCard;
    }
}
