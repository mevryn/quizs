package com.mpk.entities.question;

import com.mpk.entities.card.CharacterCard;

public class FateQuestion implements Question {
    private String body;
    private int correctAnswer;
    private CharacterCard characterCard1;
    private  CharacterCard characterCard2;
    private CharacterCard characterCard3;

    public FateQuestion(int correctAnswer, CharacterCard characterCard1, CharacterCard characterCard2, CharacterCard characterCard3) {

        this.characterCard1 = characterCard1;
        this.body = "How much fate do "+characterCard1.getName()+" cost";
        this.correctAnswer = characterCard1.getFateCost();
        this.characterCard2 = characterCard2;
        this.characterCard3 = characterCard3;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public CharacterCard getCharacterCard1() {
        return characterCard1;
    }

    public void setCharacterCard1(CharacterCard characterCard1) {
        this.characterCard1 = characterCard1;
    }

    public CharacterCard getCharacterCard2() {
        return characterCard2;
    }

    public void setCharacterCard2(CharacterCard characterCard2) {
        this.characterCard2 = characterCard2;
    }

    public CharacterCard getCharacterCard3() {
        return characterCard3;
    }

    public void setCharacterCard3(CharacterCard characterCard3) {
        this.characterCard3 = characterCard3;
    }
}
