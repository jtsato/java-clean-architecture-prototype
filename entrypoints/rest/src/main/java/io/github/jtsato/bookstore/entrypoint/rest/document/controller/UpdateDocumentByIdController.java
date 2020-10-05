package io.github.jtsato.bookstore.entrypoint.rest.document.controller;

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

import io.github.jtsato.bookstore.core.document.domain.Document;
import io.github.jtsato.bookstore.core.document.usecase.UpdateDocumentByIdUseCase;
import io.github.jtsato.bookstore.core.document.usecase.parameter.UpdateDocumentByIdParameters;
import io.github.jtsato.bookstore.entrypoint.rest.document.api.UpdateDocumentByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.request.UpdateDocumentByIdRequest;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.UpdateDocumentByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.document.mapper.UpdateDocumentByIdPresenter;
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
@RequestMapping("/documents")
public class UpdateDocumentByIdController implements UpdateDocumentByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(UpdateDocumentByIdController.class);

    private final UpdateDocumentByIdUseCase updateDocumentByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UpdateDocumentByIdResponse execute(@PathVariable final Long id, @RequestBody @DefaultValue final UpdateDocumentByIdRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> UpdateDocumentByIdController with {}", jsonRequest);

        final UpdateDocumentByIdParameters parameters = new UpdateDocumentByIdParameters(id,
                                                                                         request.getLeadId(),
                                                                                         request.getTypeId(),
                                                                                         request.getFrontPhoto(),
                                                                                         request.getBackPhoto(),
                                                                                         request.getNumber(),
                                                                                         request.getIssuer(),
                                                                                         request.getState(),
                                                                                         request.getIssueDate());
        final Document document = updateDocumentByIdUseCase.execute(parameters);
        return UpdateDocumentByIdPresenter.of(document);
    }
}
