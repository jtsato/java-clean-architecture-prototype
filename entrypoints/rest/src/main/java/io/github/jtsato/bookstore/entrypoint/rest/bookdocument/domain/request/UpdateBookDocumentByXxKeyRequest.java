package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.request;

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
public class UpdateBookDocumentByXxKeyRequest implements Serializable {

    private static final long serialVersionUID = -1167731623114356856L;

    private Long xxKey;
    private Long bookId;
    private Long size;
    private String contentType;
    private String extension;
    private String name;
    private String content;
    private String creationDate;
    private String lastModifiedDate;
}
