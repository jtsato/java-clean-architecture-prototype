package io.github.jtsato.bookstore.entrypoint.rest.document.domain.request;

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
public final class FindDocumentsByIdsRequest implements Serializable {

    private static final long serialVersionUID = -2705012639355812228L;

    private List<Long> ids;
}
