package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.request;

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
public final class SearchBookDocumentsBookAuthorRequest implements Serializable {

    private static final long serialVersionUID = -3508590383358656191L;

    private Long id;
    private String name;
    private String gender;
    private String startBirthdate;
    private String endBirthdate;
}
