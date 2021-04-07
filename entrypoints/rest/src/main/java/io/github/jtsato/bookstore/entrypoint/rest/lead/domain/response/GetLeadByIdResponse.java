package io.github.jtsato.bookstore.entrypoint.rest.lead.domain.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class GetLeadByIdResponse implements Serializable {

    private static final long serialVersionUID = 1113876181802893839L;

    private final Long id;
    private final Long selfiePhoto;
    private final String cpf;
    private final String cellphone;
    private final String name;
    private final String motherFullName;
    private final String gender;
    private final String education;
    private final String maritalStatus;
    private final Boolean stableUnion;
    private final LocalDate birthdate;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
}