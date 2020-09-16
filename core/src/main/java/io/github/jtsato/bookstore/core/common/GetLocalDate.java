package io.github.jtsato.bookstore.core.common;

import java.time.LocalDate;

/**
 * @author Jorge Takeshi Sato
 */

@FunctionalInterface
public interface GetLocalDate {

    LocalDate now();
}
