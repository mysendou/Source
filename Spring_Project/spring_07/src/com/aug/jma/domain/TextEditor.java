package com.aug.jma.domain;

public class TextEditor {
    private SpellChecker spellChecker;
    private String name;

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellchecker(SpellChecker spellChecker) {
        System.out.println("Execute Texteditor setSpellChecker method");
        this.spellChecker = spellChecker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void spellCheck(){
        spellChecker.checkSpelling();
    }
}
