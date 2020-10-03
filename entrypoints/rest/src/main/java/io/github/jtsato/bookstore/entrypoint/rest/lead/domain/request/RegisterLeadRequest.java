package io.github.jtsato.bookstore.entrypoint.rest.lead.domain.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RegisterLeadRequest implements Serializable {

    private static final long serialVersionUID = -9167136375165402883L;

    private Long selfiePhoto;
    private String cpf;
    private String cellphone;
    private String name;
    private String motherFullName;
    private String gender;
    private String education;
    private String maritalStatus;
    private Boolean stableUnion;
    private String birthdate;
    private String createdDateTime;
    private String lastModifiedDateTime;
}
