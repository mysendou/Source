package com.jeff.drools.test;

import java.beans.PersistenceDelegate;
import java.util.Collection;
import java.util.Iterator;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import com.jeff.drools.domain.Person;

public class RuleTest {
    public static void main(String[] args) {
        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        knowledgeBuilder.add(ResourceFactory.newClassPathResource("testRule.drl", HelloWorld.class), ResourceType.DRL);
        if (knowledgeBuilder.hasErrors()) {
            System.out.println("The rule include the error");
            KnowledgeBuilderErrors knowledgeBuilderErrors = knowledgeBuilder.getErrors();
            for (Iterator iter = knowledgeBuilderErrors.iterator(); iter.hasNext();) {
                System.err.println(iter.next());
            }
        }

        Collection<KnowledgePackage> kpackageCollect = knowledgeBuilder.getKnowledgePackages();
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(kpackageCollect);
        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
        Person person = new Person("Andres", "male", 22);
        session.insert(person);
        session.fireAllRules();
        session.dispose();
    }
}
