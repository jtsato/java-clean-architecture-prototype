package io.github.jtsato.bookstore.core.lead.domain;

import java.util.Arrays;

/**
 * @author Jorge Takeshi Sato
 */

public enum Education {

        ELEMENTARY_SCHOOL {

            @Override
            public String getMessageKey() {
                return "enum-education-elementary-school";
            }
        },
        MIDDLE_SCHOOL {

            @Override
            public String getMessageKey() {
                return "enum-education-middle-school";
            }
        },
        HIGH_SCHOOL {

            @Override
            public String getMessageKey() {
                return "enum-education-high-school";
            }
        },
        GRADUATED {

            @Override
            public String getMessageKey() {
                return "enum-education-graduated";
            }
        },
        POSTGRADUATE {

            @Override
            public String getMessageKey() {
                return "enum-education-postgraduate";
            }
        },
        DOCTORATE {

            @Override
            public String getMessageKey() {
                return "enum-education-doctorate";
            }
        };

    public abstract String getMessageKey();

    public boolean is(final Education other) {
        return equals(other);
    }

    public boolean isNot(final Education other) {
        return !is(other);
    }

    public boolean in(final Education... others) {
        return Arrays.asList(others).contains(this);
    }

    public boolean notIn(final Education... others) {
        return Arrays.stream(others).noneMatch(this::equals);
    }
}
