package io.github.jtsato.bookstore.entrypoint.rest.document.domain.request;

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
public final class SearchDocumentsRequest implements Serializable {

    private static final long serialVersionUID = 2233051153861657096L;

    private Long id;
    private SearchDocumentsLeadRequest lead;
    private SearchDocumentsTypeRequest type;
    private Long startFrontPhoto;
    private Long endFrontPhoto;
    private Long startBackPhoto;
    private Long endBackPhoto;
    private String number;
    private String issuer;
    private String state;
    private String startIssueDate;
    private String endIssueDate;
    private String startCreatedDateTime;
    private String endCreatedDateTime;
    private String startLastModifiedDateTime;
    private String endLastModifiedDateTime;
}
