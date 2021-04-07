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
public class UpdateDocumentTypeByIdRequest implements Serializable {

    private static final long serialVersionUID = 348035686028300094L;

    private Long id;
    private String country;
    private String description;
    private String createdDateTime;
    private String lastModifiedDateTime;
}
