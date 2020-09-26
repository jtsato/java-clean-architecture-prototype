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
public final class SearchBookDocumentsRequest implements Serializable {

    private static final long serialVersionUID = -736450563223697395L;

    private Long xxKey;
    private SearchBookDocumentsBookRequest book;
    private Long startSize;
    private Long endSize;
    private String contentType;
    private String extension;
    private String name;
    private String content;
    private String startCreationDate;
    private String endCreationDate;
    private String startLastModifiedDate;
    private String endLastModifiedDate;
}
