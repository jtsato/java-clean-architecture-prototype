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
public final class SearchDocumentsTypeRequest implements Serializable {

    private static final long serialVersionUID = -31474781345723460L;

    private Long id;
    private String country;
    private String description;
    private String startCreatedDateTime;
    private String endCreatedDateTime;
    private String startLastModifiedDateTime;
    private String endLastModifiedDateTime;
}
