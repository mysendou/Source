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

    public TextEditor(SpellChecker spellChecker, String name) {
        System.out.println("Execute TextEditor construct method");
        this.spellChecker = spellChecker;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void spellCheck() {
        spellChecker.checkSpelling();
    }
}
