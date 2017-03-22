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
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;

import com.jeff.drools.domain.Customer;
import com.jeff.drools.enums.GenericFeedRuleEnum;

public class StatefulKnowledgeSessionTest {
    public static void main(String[] args) {
        // KnowledgeBuilder 的作用就是用来在业务代码当中收集已经 编 写 好 的 规 则 ， 然 后 对 这 些 规 则 文 件 进
        // 行 编 译 ， 最 终 产 生 一 批 编 译 好 的 规 则 包（ KnowledgePackage）给其它的应用程序使用。
        KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kBuilder.add(ResourceFactory.newClassPathResource("test.drl", StatefulKnowledgeSessionTest.class), ResourceType.DRL);
        if (kBuilder.hasErrors()) {
            System.out.println("The rule include the error");
            KnowledgeBuilderErrors knowledgeBuilderErrors = kBuilder.getErrors();
            for (Iterator<?> iter = knowledgeBuilderErrors.iterator(); iter.hasNext();) {
                System.out.println(iter.next());
            }
        }

        GenericFeedRuleEnum jeffEnum = GenericFeedRuleEnum.JEFF_RULE;
        GenericFeedRuleEnum rule1 = GenericFeedRuleEnum.RULE1;
        GenericFeedRuleEnum rule2 = GenericFeedRuleEnum.RULE2;

        Customer customerrr = new Customer();
        customerrr.setName("Dillon db");
        ArrayList<Object> facts = new ArrayList<Object>();
        // facts.add(jeffEnum);
        // facts.add(customerrr);
        // facts.add(rule1);
        // facts.add(rule2);

        Collection<KnowledgePackage> kpackageCollect = kBuilder.getKnowledgePackages();
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(kpackageCollect);
        StatefulKnowledgeSession session = knowledgeBase.newStatefulKnowledgeSession();
        session.insert(rule2);
        session.insert(customerrr);
        // session.insert(rule1);
        session.fireAllRules();
        session.dispose();
    }
}
