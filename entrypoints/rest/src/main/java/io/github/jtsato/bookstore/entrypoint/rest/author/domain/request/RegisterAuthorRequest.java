package io.github.jtsato.bookstore.entrypoint.rest.author.domain.request;

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
public class RegisterAuthorRequest implements Serializable {

    private static final long serialVersionUID = 2766883218522522021L;

    private Long countryId;
    private String name;
    private String gender;
    private String birthdate;
}
