package io.github.jtsato.bookstore.entrypoint.rest.jobinformation.controller;

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

import io.github.jtsato.bookstore.core.jobinformation.domain.JobInformation;
import io.github.jtsato.bookstore.core.jobinformation.usecase.UpdateJobInformationByIdUseCase;
import io.github.jtsato.bookstore.core.jobinformation.usecase.parameter.UpdateJobInformationByIdParameters;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.api.UpdateJobInformationByIdApiMethod;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.request.UpdateJobInformationByIdRequest;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.domain.response.UpdateJobInformationByIdResponse;
import io.github.jtsato.bookstore.entrypoint.rest.jobinformation.mapper.UpdateJobInformationByIdPresenter;
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
@RequestMapping("/job-informations")
public class UpdateJobInformationByIdController implements UpdateJobInformationByIdApiMethod {

    private static final Logger log = LoggerFactory.getLogger(UpdateJobInformationByIdController.class);

    private final UpdateJobInformationByIdUseCase updateJobInformationByIdUseCase;

    @Override
    @LogExecutionTime
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public UpdateJobInformationByIdResponse execute(@PathVariable final Long id, @RequestBody @DefaultValue final UpdateJobInformationByIdRequest request) {

        final String jsonRequest = JsonConverter.of(request);
        log.info("Starting Controller -> UpdateJobInformationByIdController with {}", jsonRequest);

        final UpdateJobInformationByIdParameters parameters = new UpdateJobInformationByIdParameters(id,
                                                                                                     request.getLeadId(),
                                                                                                     request.getAttach(),
                                                                                                     request.getProfession(),
                                                                                                     request.getReferenceMonth(),
                                                                                                     request.getReceiptType(),
                                                                                                     request.getStartDate(),
                                                                                                     request.getCreatedDateTime(),
                                                                                                     request.getLastModifiedDateTime(),
                                                                                                     request.getMonthlyIncome());
        final JobInformation jobInformation = updateJobInformationByIdUseCase.execute(parameters);
        return UpdateJobInformationByIdPresenter.of(jobInformation);
    }
}
