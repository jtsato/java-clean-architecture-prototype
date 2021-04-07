package io.github.jtsato.bookstore.entrypoint.rest.address.domain.request;

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
public final class FindAddressesByIdsRequest implements Serializable {

    private static final long serialVersionUID = -8034495280063625711L;

    private List<Long> ids;
}
