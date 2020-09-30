package io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.request;

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
public final class FindDocumentTypesByIdsRequest implements Serializable {

    private static final long serialVersionUID = 192051950347044287L;

    private List<Long> ids;
}
