package com.mpk.services;

import com.mpk.entities.card.CharacterCard;
import com.mpk.repositories.CharacterCardRepository;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

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
        return characterCardRepository.findAll();
    }
    @Override
    public CharacterCard findByIdCharacterCard(int id){
        return characterCardRepository.findById(id).orElse(null);
    }
    @Override
    public Integer howManyRows(){
        Iterable<CharacterCard> listOfAllCards = listAllCharacterCards();
        Iterator<CharacterCard> iterator = listOfAllCards.iterator();
        Integer quantity = 0;
        while(iterator.hasNext()){
            iterator.next();
            quantity++;
        }
        return quantity;
    }


}
