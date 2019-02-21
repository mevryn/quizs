package com.mpk.services;

import com.mpk.entities.card.CharacterCard;

public interface CardService {

    CharacterCard saveCard(CharacterCard card);

    public Iterable<CharacterCard> listAllCharacterCards();

    public CharacterCard findByIdCharacterCard(int id);

    public Integer howManyRows();
}
