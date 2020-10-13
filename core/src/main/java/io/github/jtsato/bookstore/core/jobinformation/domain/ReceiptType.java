package io.github.jtsato.bookstore.core.jobinformation.domain;

import java.util.Arrays;

/**
 * @author Jorge Takeshi Sato
 */

public enum ReceiptType {

        PAYSLIP {

            @Override
            public String getMessageKey() {
                return "enum-receipt-type-payslip";
            }
        },
        PAYCHECH {

            @Override
            public String getMessageKey() {
                return "enum-receipt-type-paychech";
            }
        };

    public abstract String getMessageKey();

    public boolean is(final ReceiptType other) {
        return equals(other);
    }

    public boolean isNot(final ReceiptType other) {
        return !is(other);
    }

    public boolean in(final ReceiptType... others) {
        return Arrays.asList(others).contains(this);
    }

    public boolean notIn(final ReceiptType... others) {
        return Arrays.stream(others).noneMatch(this::equals);
    }
}
