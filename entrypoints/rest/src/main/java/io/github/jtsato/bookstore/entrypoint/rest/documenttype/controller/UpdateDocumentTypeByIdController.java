package io.github.jtsato.bookstore.entrypoint.rest.documenttype.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.jtsato.bookstore.core.documenttype.domain.DocumentType;
import io.github.jtsato.bookstore.core.documenttype.usecase.UpdateDocumentTypeByIdUseCase;
import io.github.jtsato.bookstore.core.documenttype.usecase.parameter.UpdateDocumentTypeByIdParameters;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.api.UpdateDocumentTypeByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.request.UpdateDocumentTypeByIdRequest;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.response.UpdateDocumentTypeByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.mapper.UpdateDocumentTypeByIdPresenter;
import io.github.jtsato.bookstore.entrypoint.rest.common.JsonConverter;
import io.github.jtsato.bookstore.entrypoint.rest.common.metric.LogExecutionTime;
import lombok.RequiredArgsConstructor;

/*
 * A EntryPoint follows these steps:
 *
 * - Maps HTTP requests to Java objects
 * - Performs authorization checks
 * - Maps input to the input model of the use case
 * - Calls the use case
 * - Maps the output of the use case back to HTTP Returns an HTTP response
 */

/**
 * @author Jorge Takeshi Sato
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/document-types")
public class UpdateDocumentTypeByIdController implements UpdateDocumentTypeByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(UpdateDocumentTypeByIdController.class);

    private final UpdateDocumentTypeByIdUseCase updateDocumentTypeByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UpdateDocumentTypeByIdResponse execute(@PathVariable final Long id, @RequestBody @DefaultValue final UpdateDocumentTypeByIdRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> UpdateDocumentTypeByIdController with {}", jsonRequest);

        final UpdateDocumentTypeByIdParameters parameters = new UpdateDocumentTypeByIdParameters(id,
                                                                                                 request.getCountry(),
                                                                                                 request.getDescription(),
                                                                                                 request.getCreatedDateTime(),
                                                                                                 request.getLastModifiedDateTime());
        final DocumentType documentType = updateDocumentTypeByIdUseCase.execute(parameters);
        return UpdateDocumentTypeByIdPresenter.of(documentType);
    }
}
