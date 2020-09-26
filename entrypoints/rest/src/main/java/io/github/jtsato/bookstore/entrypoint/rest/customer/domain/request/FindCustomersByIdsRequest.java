package io.github.jtsato.bookstore.entrypoint.rest.customer.domain.request;

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
public final class FindCustomersByIdsRequest implements Serializable {

    private static final long serialVersionUID = 6474070467240021120L;

    private List<Long> ids;
}
