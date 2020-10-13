package io.github.jtsato.bookstore.entrypoint.rest.balance.api;

import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.request.RegisterBalanceRequest;
import io.github.jtsato.bookstore.entrypoint.rest.balance.domain.response.RegisterBalanceResponse;
import io.github.jtsato.bookstore.entrypoint.rest.common.HttpStatusConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Jorge Takeshi Sato
 */

@Tag(name = "Balances")
@FunctionalInterface
public interface RegisterBalanceApiMethod {

    @Operation(summary = "Register new Balance")

    @Parameter(name = "Accept-Language",
               example = "pt_BR",
               in = ParameterIn.HEADER,
               description = "Represents a specific geographical, political, or cultural region. Language & Country.")

    @ApiResponses(value = {@ApiResponse(responseCode = HttpStatusConstants.CREATED_201, description = HttpStatusConstants.CREATED_201_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.BAD_REQUEST_400, description = HttpStatusConstants.BAD_REQUEST_400_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.UNAUTHORIZED_401, description = HttpStatusConstants.UNAUTHORIZED_401_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.FORBIDDEN_403, description = HttpStatusConstants.FORBIDDEN_403_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.INTERNAL_SERVER_ERROR_500,
                                        description = HttpStatusConstants.INTERNAL_SERVER_ERROR_500_MESSAGE),})

    RegisterBalanceResponse execute(final RegisterBalanceRequest request);
}
