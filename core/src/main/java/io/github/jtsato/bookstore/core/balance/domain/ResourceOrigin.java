package io.github.jtsato.bookstore.core.balance.domain;

import java.util.Arrays;

/**
 * @author Jorge Takeshi Sato
 */

public enum ResourceOrigin {

        JDFBR {

            @Override
            public String getMessageKey() {
                return "enum-resource-origin-jdfbr";
            }
        },
        BNDES {

            @Override
            public String getMessageKey() {
                return "enum-resource-origin-bndes";
            }
        },
        JDFAR {

            @Override
            public String getMessageKey() {
                return "enum-resource-origin-jdfar";
            }
        };

    public abstract String getMessageKey();

    public boolean is(final ResourceOrigin other) {
        return equals(other);
    }

    public boolean isNot(final ResourceOrigin other) {
        return !is(other);
    }

    public boolean in(final ResourceOrigin... others) {
        return Arrays.asList(others).contains(this);
    }

    public boolean notIn(final ResourceOrigin... others) {
        return Arrays.stream(others).noneMatch(this::equals);
    }
}
