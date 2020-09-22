package com.eeswan.software.ch05.step0;


public interface ConditionalAction {
    boolean evaluate(Facts facts);
    void perform(Facts facts);
}
