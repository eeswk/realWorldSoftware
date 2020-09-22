package com.eeswan.software.ch05.step0;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BusinessRuleEngineTest {

//
//    @Test
//    public void 규칙없는_경우_테스트() {
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);
//        assertEquals(0, businessRuleEngine.count());
//    }
//
//    @Test
//    public void 규칙이_2개_테스트() {
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);
//
//        businessRuleEngine.addAction(() -> {});
//        businessRuleEngine.addAction(() -> {});
//
//        assertEquals(2, businessRuleEngine.count());
//    }
//
//    @Test
//    public void 한개_액션_테스트() {
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);
//        final Action mockAction = mock(Action.class);
//
//        businessRuleEngine.addAction(mockAction);
//        businessRuleEngine.run();
//
//        verify(mockAction).perform();
//    }
//
//    @Test
//    public void 고객이_CEO경우_액션_기능시_메일보낸다() {
//        Customer customer = new Customer("Mark", "CEO");
//
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);
//        businessRuleEngine.addAction(new Action() {
//            @Override
//            public void perform() {
//                if ("CEO".equals(customer.getJobTitle())) {
//                    Mailer.sendMail("test@compayn.com","Relevant customer: " + customer);
//                }
//            }
//        });
//
//    }
//
//
//    @Test
//    public void 람다식_고객이_CEO경우_액션_기능시_메일보낸다() {
//        Customer customer = new Customer("Mark", "CEO");
//
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);
//        businessRuleEngine.addAction(() -> {
//            if ("CEO".equals(customer.getJobTitle())) {
//                Mailer.sendMail("test@compayn.com","Relevant customer: " + customer);
//            }
//        });
//    }
//
//    @Test
//    public void 액션과_팩트_실행시() {
//        final Action mockAction = mock(Action.class);
//        final Facts mockFacts = mock(Facts.class);
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mockFacts);
//
//        businessRuleEngine.addAction(mockAction);
//        businessRuleEngine.run();
//
//        verify(mockAction).perform(mockFacts);
//    }
//
//    @Test
//    public void Facts를_이용하는_액션() {
//        Customer customer = new Customer("Mark", "CEO");
//        final Facts facts = mock(Facts.class);
//
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);
//        businessRuleEngine.addAction(() -> {
//            final String jobTitle = facts.getFact("JobTitle");
//            if ("CEO".equals(jobTitle)) {
//                final String name = facts.getFact("name");
//                Mailer.sendMail("test@compayn.com","Relevant customer: " + name);
//            }
//        });
//    }
//
//
//    @Test
//    public void Facts를_이용하는_액션_추론형식() {
//        var customer = new Customer("Mark", "CEO");
//        var facts = mock(Facts.class);
//
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(facts);
//        businessRuleEngine.addAction(() -> {
//            var jobTitle = facts.getFact("JobTitle");
//            if ("CEO".equals(jobTitle)) {
//                var name = facts.getFact("name");
//                Mailer.sendMail("test@compayn.com", "Relevant customer: " + name);
//            }
//        });
//    }
//
//    @Test
//    public void 특정_거래의_예상치를_계산하는_규칙() {
//        final BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(mock(Facts.class));
//        businessRuleEngine.addAction(facts -> {
//
//            var dealStage = Stage.valueOf(facts.getFact("stage"));
//            var amount = Double.parseDouble(facts.getFact("amount"));
//
//            var forecastedAmout = amount * switch(dealStage) {
//                case LEAD -> 0.2;
//                case EVALUATING -> 0.5;
//                case INTERSTED -> 0.8;
//                case CLOSED -> 1;
//            };
//
//            facts.addFacts("forecastedAmount", String.valueOf(forecastedAmout));
//        });
//    }

}
