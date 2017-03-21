package com.jeff.drools;

import java.util.ArrayList;
import java.util.Collection;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatelessKnowledgeSession;

public class RuleEngine {
    public static void main(String[] args) {
        String ruleDrl = "t.drl";
        Person dillon = new Person("dillon","male");
        Person ricky = new Person("ricky", "female");
        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        knowledgeBuilder.add(ResourceFactory.newClassPathResource(ruleDrl), ResourceType.DRL);
        if (knowledgeBuilder.hasErrors()) {
            System.err.println(knowledgeBuilder.getErrors().toString());
        }
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase(); 
        Collection<KnowledgePackage> knowledgePackages = knowledgeBuilder.getKnowledgePackages();
        knowledgeBase.addKnowledgePackages(knowledgePackages);
        
        StatelessKnowledgeSession session  = knowledgeBase.newStatelessKnowledgeSession();
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(dillon);
        list.add(ricky);
        session.execute(list);
        System.out.println(list);
    }
}
