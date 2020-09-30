package io.github.jtsato.bookstore.core.address.domain;

import java.util.Arrays;

/**
 * @author Jorge Takeshi Sato
 */

public enum PropertyType {

        RENTED_HOUSE {

            @Override
            public String getMessageKey() {
                return "enum-property-type-rented-house";
            }
        },
        OWN_HOME {

            @Override
            public String getMessageKey() {
                return "enum-property-type-own-home";
            }
        };

    public abstract String getMessageKey();

    public boolean is(final PropertyType other) {
        return equals(other);
    }

    public boolean isNot(final PropertyType other) {
        return !is(other);
    }

    public boolean in(final PropertyType... others) {
        return Arrays.asList(others).contains(this);
    }

    public boolean notIn(final PropertyType... others) {
        return Arrays.stream(others).noneMatch(this::equals);
    }
}

