package io.github.jtsato.bookstore.entrypoint.rest.country.domain.request;

import java.io.Serializable;

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
public class RegisterCountryRequest implements Serializable {

    private static final long serialVersionUID = -1895786267750216526L;

    private String name;
}