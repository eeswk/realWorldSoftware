package com.eeswan.software.ch05.step0;

public class Report {
    private final ConditionalAction conditionalAction;
    private final Facts facts;
    private final boolean isPositive;

    public Report(Facts facts, ConditionalAction conditionalAction, boolean isPositive) {
        this.facts = facts;
        this.conditionalAction = conditionalAction;
        this.isPositive = isPositive;
    }

    public ConditionalAction getConditionalAction() {
        return conditionalAction;
    }

    public Facts getFacts() {
        return facts;
    }

    public boolean isPositive() {
        return isPositive;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Report{");
        sb.append("conditionalAction=").append(conditionalAction);
        sb.append(", facts=").append(facts);
        sb.append(", isPositive=").append(isPositive);
        sb.append('}');
        return sb.toString();
    }
}
