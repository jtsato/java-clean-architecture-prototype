package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response;

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
public class RegisterJobInformationLeadResponse implements Serializable {

    private static final long serialVersionUID = -9105138150536952838L;

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
