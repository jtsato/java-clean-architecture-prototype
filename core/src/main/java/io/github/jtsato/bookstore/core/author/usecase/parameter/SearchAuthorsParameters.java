package io.github.jtsato.bookstore.core.author.usecase.parameter;

import java.io.Serializable;

import org.apache.commons.lang3.tuple.ImmutablePair;

import io.github.jtsato.bookstore.core.country.usecase.parameter.SearchCountriesParameters;
import io.github.jtsato.bookstore.core.common.validation.LocalDateConstraint;
import io.github.jtsato.bookstore.core.common.validation.SelfValidating;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@EqualsAndHashCode(callSuper = false)
@ToString
public class SearchAuthorsParameters extends SelfValidating<SearchAuthorsParameters> implements Serializable {

    private static final long serialVersionUID = -3341334271834240605L;

    private Long id;

    private SearchCountriesParameters searchCountriesParameters;

    private String name;

    private String gender;

    @LocalDateConstraint(message = "validation.author.start.birthdate.invalid")
    private String startBirthdate;

    @LocalDateConstraint(message = "validation.author.end.birthdate.invalid")
    private String endBirthdate;

    public SearchAuthorsParameters(final Long id,
                                   final SearchCountriesParameters searchCountriesParameters,
                                   final String name,
                                   final String gender,
                                   final ImmutablePair<String, String> birthdateRange) {
        this.id = id;
        this.searchCountriesParameters = searchCountriesParameters;
        this.name = name;
        this.gender = gender;
        this.startBirthdate = birthdateRange.getLeft();
        this.endBirthdate = birthdateRange.getRight();
        this.validateSelf();
    }
}