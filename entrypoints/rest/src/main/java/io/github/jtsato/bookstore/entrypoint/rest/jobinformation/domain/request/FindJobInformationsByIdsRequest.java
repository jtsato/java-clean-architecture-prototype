package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.request;

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
public final class FindJobInformationsByIdsRequest implements Serializable {

    private static final long serialVersionUID = -9147918875401107913L;

    private List<Long> ids;
}
