package io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.request;

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
public class RegisterDocumentTypeRequest implements Serializable {

    private static final long serialVersionUID = 7478492754150179337L;

    private String country;
    private String description;
    private String createdDateTime;
    private String lastModifiedDateTime;
}
