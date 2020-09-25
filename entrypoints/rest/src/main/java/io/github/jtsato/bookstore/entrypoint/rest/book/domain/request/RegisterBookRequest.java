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

    private static final long serialVersionUID = -3060928567668816423L;

    private Long authorId;
    private String title;
    private String isbn;
    private Boolean available;
    private String createdDateTime;
    private String lastModifiedDateTime;
    private BigDecimal price;
}
