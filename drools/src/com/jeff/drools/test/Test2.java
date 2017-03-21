package com.jeff.drools.test;

import java.util.ArrayList;
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
import org.drools.runtime.StatelessKnowledgeSession;

import com.jeff.drools.enums.GenericFeedRuleEnum;

public class Test2 {
    public static void main(String[] args) {

        KnowledgeBuilder knowledgeBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        knowledgeBuilder.add(ResourceFactory.newClassPathResource("test2.drl",Test2.class), ResourceType.DRL);
        if(knowledgeBuilder.hasErrors()){
            System.out.println("The rule include the error");
            KnowledgeBuilderErrors knowledgeBuilderErrors = knowledgeBuilder.getErrors();
            for (Iterator iter = knowledgeBuilderErrors.iterator();iter.hasNext();) {
                System.err.println(iter.next());
            }
        }

        GenericFeedRuleEnum jeffEnum = GenericFeedRuleEnum.JEFF_RULE;
        ArrayList<Object> facts = new ArrayList<Object>();
        facts.add(jeffEnum);

        //得到所有规则包的集合
        Collection<KnowledgePackage> kpackageCollect = knowledgeBuilder.getKnowledgePackages();
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(kpackageCollect);
        StatelessKnowledgeSession session = knowledgeBase.newStatelessKnowledgeSession();
        session.execute(facts);
        System.out.println("............end");
        
    }
}
