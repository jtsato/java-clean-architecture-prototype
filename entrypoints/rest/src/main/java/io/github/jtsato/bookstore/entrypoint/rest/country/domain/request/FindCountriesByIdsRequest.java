package io.github.jtsato.bookstore.entrypoint.rest.country.domain.request;

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
public final class FindCountriesByIdsRequest implements Serializable {

    private static final long serialVersionUID = -3894841767975829199L;

    private List<Long> ids;
}
