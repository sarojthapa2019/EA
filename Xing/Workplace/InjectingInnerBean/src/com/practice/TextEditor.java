package com.practice;

public class TextEditor {
    private SpellChecker spellChecker;

    public TextEditor(){

    }
    public void spellCheck(){
        spellChecker.checkSpelling();
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("Inside setSpellChecker");
        this.spellChecker = spellChecker;
    }
}
