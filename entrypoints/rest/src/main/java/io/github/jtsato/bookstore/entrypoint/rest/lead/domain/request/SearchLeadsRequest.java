package io.github.jtsato.bookstore.entrypoint.rest.lead.domain.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public final class SearchLeadsRequest implements Serializable {

    private static final long serialVersionUID = -6825113670219642225L;

    private Long id;
    private Long startSelfiePhoto;
    private Long endSelfiePhoto;
    private String cpf;
    private String cellphone;
    private String name;
    private String motherFullName;
    private String gender;
    private String education;
    private String maritalStatus;
    private Boolean stableUnion;
    private String startBirthdate;
    private String endBirthdate;
    private String startCreatedDateTime;
    private String endCreatedDateTime;
    private String startLastModifiedDateTime;
    private String endLastModifiedDateTime;
}
