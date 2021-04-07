package io.github.jtsato.bookstore.entrypoint.rest.address.api;

import io.github.jtsato.bookstore.entrypoint.rest.address.domain.response.GetAddressByIdResponse;
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

@Tag(name = "Addresses")
@FunctionalInterface
public interface GetAddressByIdApiMethod {

    @Operation(summary = "Get Address by Id")

    @Parameter(name = "Accept-Language",
               example = "pt_BR",
               in = ParameterIn.HEADER,
               description = "Represents a specific geographical, political, or cultural region. Language & Country.")

    @ApiResponses(value = {@ApiResponse(responseCode = HttpStatusConstants.OK_200, description = HttpStatusConstants.OK_200_MESSAGE),
                           @ApiResponse(description = HttpStatusConstants.BAD_REQUEST_400_MESSAGE),
                           @ApiResponse(description = HttpStatusConstants.NOT_FOUND_404_MESSAGE),
                           @ApiResponse(description = HttpStatusConstants.INTERNAL_SERVER_ERROR_500_MESSAGE),})

    GetAddressByIdResponse execute(@Parameter(description = "Address Id") final Long id);
}