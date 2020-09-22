package io.github.jtsato.bookstore.core.enumerator.domain;

import java.io.Serializable;

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
public class Enumerator implements Serializable {

    private static final long serialVersionUID = 1121627709909257418L;

    private final String domain;
    private final String key;
    private final String messageKey;
}

