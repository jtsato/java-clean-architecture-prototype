package io.github.jtsato.bookstore.entrypoint.rest.book.domain.request;

import java.io.Serializable;
import java.util.List;

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
public final class FindBooksByIdsRequest implements Serializable {

    private static final long serialVersionUID = -3786860490478435969L;

    private List<Long> ids;
}
