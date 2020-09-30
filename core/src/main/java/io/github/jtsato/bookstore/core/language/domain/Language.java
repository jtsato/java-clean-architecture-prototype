package io.github.jtsato.bookstore.core.language.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
public class Language implements Serializable {

    private static final long serialVersionUID = -709935799089020148L;

    private final Long id;
    private final String name;
    private final LocalDateTime createdDateTime;
    private final LocalDateTime lastModifiedDateTime;
}
