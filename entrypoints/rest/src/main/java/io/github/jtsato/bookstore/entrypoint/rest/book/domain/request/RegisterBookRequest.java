package io.github.jtsato.bookstore.entrypoint.rest.book.domain.request;

import java.io.Serializable;
import java.math.BigDecimal;

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
public class RegisterBookRequest implements Serializable {

    private static final long serialVersionUID = -2391117958857797812L;

    private Long authorId;
    private Long externalId;
    private String title;
    private String isbn;
    private Boolean available;
    private String createdDateTime;
    private String lastModifiedDateTime;
    private BigDecimal price;
}
