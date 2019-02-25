package com.mpk.controllers;

import com.mpk.entities.card.CharacterCard;
import com.mpk.entities.card.trait.Clan;
import com.mpk.entities.card.trait.PersonTrait;
import com.mpk.services.CharacterCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class IndexController {
    private boolean modelGenerated=false;
    @Autowired
    private CharacterCardService characterCardService;
    @RequestMapping(value="/",method = POST)
    public String generateModel(){
        if(!modelGenerated) {
            Set<PersonTrait> personTraits = new HashSet<>();
            personTraits.add(PersonTrait.BUSHI);
            personTraits.add(PersonTrait.SHUGENJA);
            personTraits.add(PersonTrait.CHAMPION);
            CharacterCard card1 = new CharacterCard("Togashi Jokuni", "Action: Choose a triggered ability printed on another character – this character gains that ability until the end of the phase. (Max 1 per round.)", Clan.DRAGON, 5, 5, 5, 3, "What transpires in our mountains is a mere pebble against the avalanche that is coming.", personTraits, false);
            characterCardService.saveCard(card1);
            personTraits = new HashSet<>();
            personTraits.add(PersonTrait.COURTIER);
            characterCardService.saveCard(new CharacterCard("Bayushi Kachiko", "While this character is participating in a Political conflict, choose a participating character with lower Political skill than this character – move the chosen character home. Then, you may bow it.", Clan.SCORPION, 5, 3, 6, 3, "Which of us would bid this game to end? We are nearly perfectly matched, but there can only be one victor.", personTraits, true));
            return "Model generated";
        }else{
            return "Model was generated";
        }
    }
}
