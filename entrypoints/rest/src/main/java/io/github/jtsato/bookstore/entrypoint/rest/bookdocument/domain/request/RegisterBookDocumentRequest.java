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
public class RegisterBookDocumentRequest implements Serializable {

    private static final long serialVersionUID = 1149291861191509331L;

    private Long bookId;
    private Long size;
    private String contentType;
    private String extension;
    private String name;
    private String content;
    private String creationDate;
    private String lastModifiedDate;
}
