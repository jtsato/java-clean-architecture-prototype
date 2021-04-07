package io.github.jtsato.bookstore.entrypoint.rest.file.domain.request;

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
public final class SearchFilesRequest implements Serializable {

    private static final long serialVersionUID = 1010629614818510926L;

    private Long id;
    private Long startSize;
    private Long endSize;
    private String contentType;
    private String extension;
    private String name;
    private String content;
    private String url;
    private String startCreationDate;
    private String endCreationDate;
    private String startLastModifiedDate;
    private String endLastModifiedDate;
}
