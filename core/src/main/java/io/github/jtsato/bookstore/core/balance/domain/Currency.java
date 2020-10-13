package io.github.jtsato.bookstore.core.balance.domain;

import java.util.Arrays;

/**
 * @author Jorge Takeshi Sato
 */

public enum Currency {

        BRL {

            @Override
            public String getMessageKey() {
                return "enum-currency-brl";
            }
        },
        USD {

            @Override
            public String getMessageKey() {
                return "enum-currency-usd";
            }
        };

    public abstract String getMessageKey();

    public boolean is(final Currency other) {
        return equals(other);
    }

    public boolean isNot(final Currency other) {
        return !is(other);
    }

    public boolean in(final Currency... others) {
        return Arrays.asList(others).contains(this);
    }

    public boolean notIn(final Currency... others) {
        return Arrays.stream(others).noneMatch(this::equals);
    }
}
