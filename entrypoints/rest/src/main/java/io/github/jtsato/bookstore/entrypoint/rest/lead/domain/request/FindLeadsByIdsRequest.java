package io.github.jtsato.bookstore.entrypoint.rest.lead.domain.request;

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
public final class FindLeadsByIdsRequest implements Serializable {

    private static final long serialVersionUID = -5501480543372359756L;

    private List<Long> ids;
}
