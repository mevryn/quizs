package com.mpk.services;

import com.mpk.entities.card.Card;
import com.mpk.entities.card.CharacterCard;

public interface CardService {

    CharacterCard saveCard(CharacterCard card);

    public Iterable<CharacterCard> listAllCharacterCards();

}
