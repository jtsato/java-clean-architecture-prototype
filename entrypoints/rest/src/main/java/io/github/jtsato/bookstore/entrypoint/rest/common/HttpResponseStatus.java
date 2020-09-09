package io.github.jtsato.bookstore.entrypoint.rest.common;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Jorge Takeshi Sato  
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HttpResponseStatus implements Serializable {

    private static final long serialVersionUID = 8064654986394553079L;

    private LocalDateTime timestamp;

    private long status;

    private String error;

    private String message;

    private String path;
}
