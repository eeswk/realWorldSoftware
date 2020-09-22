package com.eeswan.software.ch04.step0;

import java.util.Map;

public class Document {
    private final Map<String, String> attributes;

    Document(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(final String attribute) {
        return attributes.get(attribute);
    }
}
