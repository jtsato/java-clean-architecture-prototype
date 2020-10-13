package io.github.jtsato.bookstore.entrypoint.rest.balance.domain.response;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@AllArgsConstructor
public class SessionResponse implements Serializable {

    private static final long serialVersionUID = -6228021349409183903L;
    
    private final BigDecimal principal;
    private final BigDecimal interest;
    private final BigDecimal total;
}
