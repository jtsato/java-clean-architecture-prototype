package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.request;

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
public final class FindBookDocumentsByXxKeysRequest implements Serializable {

    private static final long serialVersionUID = 6789265003135190843L;

    private List<Long> xxKeys;
}
