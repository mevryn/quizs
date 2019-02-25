package com.mpk.controllers;

import com.mpk.entities.card.CharacterCard;
import com.mpk.entities.question.FateQuestion;
import com.mpk.entities.question.Question;
import com.mpk.repositories.CharacterCardRepository;
import com.mpk.services.CharacterCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.Random;

@RestController
public class QuestionController {
    @Autowired
    private CharacterCardService characterCardService;

    @RequestMapping(value = "/question", method = RequestMethod.GET)
    public FateQuestion getFateqQuestion() {
        int type = new Random().nextInt(1);
        Integer rowsQuntity = characterCardService.howManyRows();

        Integer randomCorrectCard,secondFalseCard, thirdFalseCard;
        CharacterCard firstCard, secondCard, thirdCard;
        System.out.println(rowsQuntity);
        randomCorrectCard = new Random().nextInt(rowsQuntity) + 1;
        while(true) {
            secondFalseCard = new Random().nextInt(rowsQuntity) + 1;
            if (!secondFalseCard.equals(randomCorrectCard)) {
                break;
            }
        }
        while(true) {
            thirdFalseCard = new Random().nextInt(rowsQuntity) + 1;
                if (!thirdFalseCard.equals(randomCorrectCard) && !thirdFalseCard.equals(secondFalseCard)) {
                    break;
                }
            }

        firstCard = characterCardService.findByIdCharacterCard(randomCorrectCard);
        secondCard = characterCardService.findByIdCharacterCard(secondFalseCard);
        thirdCard = characterCardService.findByIdCharacterCard(thirdFalseCard);
        switch (type) {
            case 0:
                return new FateQuestion(randomCorrectCard, firstCard, secondCard, thirdCard);
            case 1:
                break;
            default:
                return null;
        }return null;

    }
}