package com.eeswan.software.ch05.step0;

import java.util.HashMap;
import java.util.Map;

public class Facts {
    private final Map<String, String> facts = new HashMap<>();

    public String getFact(final String name) {
        return facts.get(name);
    }

    public void addFacts(final String name, final String value) {
        facts.put(name, value);
    }

}
