package io.github.jtsato.bookstore.entrypoint.rest.file.domain.request;

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
public final class FindFilesByIdsRequest implements Serializable {

    private static final long serialVersionUID = -8722411477868066236L;

    private List<Long> ids;
}
