package com.aug.jma.domain;

public class TextEditor {

    private SpellChecker spellChecker;
    public TextEditor(SpellChecker spellchecker) {
        System.out.println("Execute TextEditor construct");
        this.spellChecker = spellchecker;
    }
    
    public void spellCheck(){
        System.out.println("Execute TextEditor spell check");
        spellChecker.spellCheck();
    }

}
