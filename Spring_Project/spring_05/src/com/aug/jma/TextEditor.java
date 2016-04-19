package com.aug.jma;

public class TextEditor {
    private SpellChecker spellChecker;

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    /*
     * <property name="spellChecker" ref="spellChecker"/>
     * 如果method的名字是setA 那么在beans.xml里面的这条映射应该修改为<property name="a" ref="spellChecker"/>
     */
    public void setSpellChecker(SpellChecker spellChecker) {
        System.out.println("Execute TextEditor setSpellChecker");
        this.spellChecker = spellChecker;
    }
    
    public void spellCheck(){
        System.out.println("Execute TextEditor spellCheck Method");
        spellChecker.checkSpelling();
    }
}
