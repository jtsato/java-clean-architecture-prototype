package io.github.jtsato.bookstore.entrypoint.rest.file.api;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;

import io.github.jtsato.bookstore.entrypoint.rest.file.domain.request.SearchFilesRequest;
import io.github.jtsato.bookstore.entrypoint.rest.file.domain.response.SearchFilesWrapperResponse;
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

@Tag(name = "Files")
@FunctionalInterface
public interface SearchFilesApiMethod {

    @Operation(summary = "Search Files")

    @Parameter(name = "Accept-Language",
               example = "pt_BR",
               in = ParameterIn.HEADER,
               description = "Represents a specific geographical, political, or cultural region. Language & Country.")

    @PageableAsQueryParam

    @Parameter(in = ParameterIn.QUERY,
               name = "id",
               description = "File id that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "contentType",
               description = "File content type that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "extension",
               description = "File extension that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "name",
               description = "File name that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "startSize",
               description = "Filters file's size greater than or equal to the specified value.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "endSize",
               description = "Filters file's size less than or equal to the specified value.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "content",
               description = "File content that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "url",
               description = "File url that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "startCreationDate",
               description = "Filters file's creation date after the specified date. Format: YYYY-MM-DD",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "endCreationDate",
               description = "Filters file's creation date before the specified date. Format: YYYY-MM-DD",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "startLastModifiedDate",
               description = "Filters file's last modified date after the specified date. Format: YYYY-MM-DD",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "endLastModifiedDate",
               description = "Filters file's last modified date before the specified date. Format: YYYY-MM-DD",
               content = @Content(schema = @Schema(type = "string")))

    @ApiResponses(value = {@ApiResponse(responseCode = HttpStatusConstants.OK_200, description = HttpStatusConstants.OK_200_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.BAD_REQUEST_400, description = HttpStatusConstants.BAD_REQUEST_400_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.UNAUTHORIZED_401, description = HttpStatusConstants.UNAUTHORIZED_401_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.FORBIDDEN_403, description = HttpStatusConstants.FORBIDDEN_403_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.NOT_FOUND_404, description = HttpStatusConstants.NOT_FOUND_404_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.INTERNAL_SERVER_ERROR_500,
                                         description = HttpStatusConstants.INTERNAL_SERVER_ERROR_500_MESSAGE),})

    SearchFilesWrapperResponse execute(@Parameter(hidden = true) final Pageable pageable, @Parameter(hidden = true) final SearchFilesRequest request);
}
