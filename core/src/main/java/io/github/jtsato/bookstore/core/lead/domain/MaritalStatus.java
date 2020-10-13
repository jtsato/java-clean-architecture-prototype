package io.github.jtsato.bookstore.core.lead.domain;

import java.util.Arrays;

/**
 * @author Jorge Takeshi Sato
 */

public enum MaritalStatus {

        SINGLE {

            @Override
            public String getMessageKey() {
                return "enum-marital-status-single";
            }
        },
        MARRIED {

            @Override
            public String getMessageKey() {
                return "enum-marital-status-married";
            }
        },
        SEPARATED {

            @Override
            public String getMessageKey() {
                return "enum-marital-status-separated";
            }
        },
        DIVORCED {

            @Override
            public String getMessageKey() {
                return "enum-marital-status-divorced";
            }
        },
        WIDOWED {

            @Override
            public String getMessageKey() {
                return "enum-marital-status-widowed";
            }
        };

    public abstract String getMessageKey();

    public boolean is(final MaritalStatus other) {
        return equals(other);
    }

    public boolean isNot(final MaritalStatus other) {
        return !is(other);
    }

    public boolean in(final MaritalStatus... others) {
        return Arrays.asList(others).contains(this);
    }

    public boolean notIn(final MaritalStatus... others) {
        return Arrays.stream(others).noneMatch(this::equals);
    }
}
