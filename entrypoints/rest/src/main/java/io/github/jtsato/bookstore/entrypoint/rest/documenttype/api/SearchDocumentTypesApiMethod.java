package io.github.jtsato.bookstore.entrypoint.rest.documenttype.api;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;

import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.request.SearchDocumentTypesRequest;
import io.github.jtsato.bookstore.entrypoint.rest.documenttype.domain.response.SearchDocumentTypesWrapperResponse;
import io.github.jtsato.bookstore.entrypoint.rest.common.HttpStatusConstants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Jorge Takeshi Sato
 */

@Tag(name = "DocumentTypes")
@FunctionalInterface
public interface SearchDocumentTypesApiMethod {

    @Operation(summary = "Search DocumentTypes")

    @Parameter(name = "Accept-Language",
               example = "pt_BR",
               in = ParameterIn.HEADER,
               description = "Represents a specific geographical, political, or cultural region. Language & Country.")

    @PageableAsQueryParam

    @Parameter(in = ParameterIn.QUERY,
               name = "id",
               description = "DocumentType id that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "country",
               description = "DocumentType country that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "description",
               description = "DocumentType description that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "startCreatedDateTime",
               description = "Filters documentType's created date time after the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "endCreatedDateTime",
               description = "Filters documentType's created date time before the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "startLastModifiedDateTime",
               description = "Filters documentType's last modified date time after the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "endLastModifiedDateTime",
               description = "Filters documentType's last modified date time before the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))

    @ApiResponses(value = {@ApiResponse(responseCode = HttpStatusConstants.OK_200, description = HttpStatusConstants.OK_200_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.BAD_REQUEST_400, description = HttpStatusConstants.BAD_REQUEST_400_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.UNAUTHORIZED_401, description = HttpStatusConstants.UNAUTHORIZED_401_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.FORBIDDEN_403, description = HttpStatusConstants.FORBIDDEN_403_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.NOT_FOUND_404, description = HttpStatusConstants.NOT_FOUND_404_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.INTERNAL_SERVER_ERROR_500,
                                         description = HttpStatusConstants.INTERNAL_SERVER_ERROR_500_MESSAGE),})

    SearchDocumentTypesWrapperResponse execute(@Parameter(hidden = true) final Pageable pageable, @Parameter(hidden = true) final SearchDocumentTypesRequest request);
}
