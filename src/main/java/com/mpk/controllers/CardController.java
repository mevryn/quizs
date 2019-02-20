package com.mpk.controllers;

import com.mpk.entities.card.CharacterCard;
import com.mpk.services.CharacterCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController
{
    @Autowired
    private CharacterCardService characterCardService;

    @RequestMapping(value = "/characters", method = RequestMethod.GET)
    public Iterable<CharacterCard> list(CharacterCard model) {
        return characterCardService.listAllCharacterCards();
    }
}
