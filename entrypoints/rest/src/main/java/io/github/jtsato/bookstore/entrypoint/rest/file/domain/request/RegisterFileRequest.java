package io.github.jtsato.bookstore.entrypoint.rest.file.domain.request;

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
public class RegisterFileRequest implements Serializable {

    private static final long serialVersionUID = -3395986853297828104L;

    private Long size;
    private String contentType;
    private String extension;
    private String name;
    private String content;
    private String url;
    private String creationDate;
    private String lastModifiedDate;
}
