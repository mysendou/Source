package com.jeff.drools.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.command.Command;
import org.drools.command.CommandFactory;
import org.drools.definition.KnowledgePackage;
import org.drools.io.ResourceFactory;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.StatelessKnowledgeSession;

import com.jeff.drools.domain.Customer;
import com.jeff.drools.enums.GenericFeedRuleEnum;

public class StatelessKnowledgeSessionTest {
    public static void main(String[] args) {
        KnowledgeBuilder kBuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
        kBuilder.add(ResourceFactory.newClassPathResource("test.drl", StatelessKnowledgeSessionTest.class), ResourceType.DRL);
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

        Customer customer = new Customer();
        customer.setName("dillon db");
        ArrayList<Object> facts = new ArrayList<Object>();
        facts.add(jeffEnum);
        facts.add(customer);
        facts.add(rule1);
        facts.add(rule2);

        Collection<KnowledgePackage> kpackageCollect = kBuilder.getKnowledgePackages();
        KnowledgeBase knowledgeBase = KnowledgeBaseFactory.newKnowledgeBase();
        knowledgeBase.addKnowledgePackages(kpackageCollect);
        StatelessKnowledgeSession session = knowledgeBase.newStatelessKnowledgeSession();
        // add one fact
        // session.execute(CommandFactory.newInsert(rule1));

        // add more fact
        List<Command> cmds = new ArrayList<Command>();
        cmds.add(CommandFactory.newInsert(rule1));
        cmds.add(CommandFactory.newInsert(customer));
        cmds.add(CommandFactory.newInsert(rule2));
        session.execute(CommandFactory.newBatchExecution(cmds));

        // session.execute(facts);
        System.out.println("............end");
    }
}
