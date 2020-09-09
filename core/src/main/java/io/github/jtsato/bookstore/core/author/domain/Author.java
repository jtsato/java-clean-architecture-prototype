package io.github.jtsato.bookstore.core.author.domain;

import java.io.Serializable;
import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato  
 */

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Author implements Serializable {

    private static final long serialVersionUID = 3513556731079574693L;

    private final long id;
    private final Gender gender;
    private final String name;
    private final LocalDate birthdate;
}

