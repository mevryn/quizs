package com.mpk.services;

import com.mpk.entities.card.Card;
import com.mpk.entities.card.CharacterCard;
import com.mpk.repositories.CharacterCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CharacterCardService implements CardService {

    @Autowired
    private CharacterCardRepository characterCardRepository;


    @Override
    public CharacterCard saveCard(CharacterCard card) {
        return characterCardRepository.save(card);
    }

    @Override
    public Iterable<CharacterCard> listAllCharacterCards() {
        return characterCardRepository.findAllCharacterCards();
    }

    public CharacterCard listFirstCharacterCard(){
        return characterCardRepository.findById(0).orElse(null);
    }




}
