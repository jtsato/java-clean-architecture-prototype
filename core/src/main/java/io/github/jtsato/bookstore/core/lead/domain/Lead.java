package io.github.jtsato.bookstore.core.lead.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
public class Lead implements Serializable {

    private static final long serialVersionUID = 3025128013687115524L;

    private final Long id;
    private final Long selfiePhoto;
    private final String cpf;
    private final String cellphone;
    private final String name;
    private final String motherFullName;
    private final Gender gender;
    private final Education education;
    private final MaritalStatus maritalStatus;
    private final Boolean stableUnion;
    private final LocalDate birthdate;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
}
