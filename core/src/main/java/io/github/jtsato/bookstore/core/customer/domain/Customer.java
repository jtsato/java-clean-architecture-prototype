package io.github.jtsato.bookstore.core.customer.domain;

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
public class Customer implements Serializable {

    private static final long serialVersionUID = -8949244864288309177L;

    private final Long id;
    private final String name;
    private final String address;
}
