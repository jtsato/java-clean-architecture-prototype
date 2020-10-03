package io.github.jtsato.bookstore.entrypoint.rest.common;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Jorge Takeshi Sato
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WebRequest implements Serializable {

    private static final long serialVersionUID = 4507713027628223865L;

    protected String path;
}
