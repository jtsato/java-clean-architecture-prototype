package io.github.jtsato.bookstore.entrypoint.rest.balance.domain.request;

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
public final class FindBalancesByIdsRequest implements Serializable {

    private static final long serialVersionUID = -1877869628734682699L;

    private List<Long> ids;
}
