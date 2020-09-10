package io.github.jtsato.bookstore.core.author.usecase.parameter;

import java.io.Serializable;

import org.apache.commons.lang3.tuple.ImmutablePair;

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
public class SearchAuthorsParameters extends SelfValidating<SearchAuthorsParameters>  implements Serializable {

    private static final long serialVersionUID = 8083838705541005686L;

    private Long id;

	private String gender;

	private String name;

    @LocalDateConstraint(message = "validation.Author.start.birthdate.invalid")
    private String startBirthdate;

    @LocalDateConstraint(message = "validation.Author.end.birthdate.invalid")
    private String endBirthdate;
    
    public SearchAuthorsParameters(final Long id, final String name, final String gender, final String startBirthdateDate, final String endBirthdateDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.startBirthdateDate = startBirthdateDate;
        this.endBirthdateDate = endBirthdateDate;
        this.validateSelf();
    }
}