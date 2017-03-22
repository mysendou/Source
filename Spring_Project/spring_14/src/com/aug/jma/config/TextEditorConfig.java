package com.aug.jma.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.aug.jma.domain.SpellChecker;
import com.aug.jma.domain.TextEditor;

@Configuration
public class TextEditorConfig {

    @Bean
    public TextEditor textEditor(){
        return new TextEditor(spellchecker());
    }
    
    @Bean
    public SpellChecker spellchecker(){
        return new SpellChecker();
    }
}
