package io.github.jtsato.bookstore.core.common;

import java.time.LocalDate;

import javax.inject.Named;

/**
 * @author Jorge Takeshi Sato
 */

@Named
public class GetLocalDateImpl implements GetLocalDate {

    @Override
    public LocalDate now() {
        return LocalDate.now();
    }
}
