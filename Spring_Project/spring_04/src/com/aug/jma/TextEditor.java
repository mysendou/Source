package com.aug.jma;

public class TextEditor {
    private SpellChecker spellChecker;

    public TextEditor(SpellChecker spellChecker){
        System.out.println("Execute TextEditor Constructor");
        this.spellChecker = spellChecker;
    }

    public void spellCheck() {
        System.out.println("Execute TextEditor SpellCheck Method");
        spellChecker.checkSpelling();
    }
}
