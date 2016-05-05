package com.aug.jma.domain;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {
    private SpellChecker spellChecker;

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    @Autowired
    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }
    
    public void spellCheck(){
        System.out.println("Execute TextEditor spell Check");
        spellChecker.chckeSpell();
    }
}
