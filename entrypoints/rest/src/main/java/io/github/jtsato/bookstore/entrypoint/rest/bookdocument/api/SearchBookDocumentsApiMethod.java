package io.github.jtsato.bookstore.entrypoint.rest.bookdocument.api;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;

import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.request.SearchBookDocumentsRequest;
import io.github.jtsato.bookstore.entrypoint.rest.bookdocument.domain.response.SearchBookDocumentsWrapperResponse;
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

@Tag(name = "BookDocuments")
@FunctionalInterface
public interface SearchBookDocumentsApiMethod {

    @Operation(summary = "Search BookDocuments")

    @Parameter(name = "Accept-Language",
               example = "pt_BR",
               in = ParameterIn.HEADER,
               description = "Represents a specific geographical, political, or cultural region. Language & Country.")

    @PageableAsQueryParam

    @Parameter(in = ParameterIn.QUERY,
               name = "xxKey",
               description = "BookDocument xxKey that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "contentType",
               description = "BookDocument content type that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "extension",
               description = "BookDocument extension that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "name",
               description = "BookDocument name that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "startSize",
               description = "Filters bookDocument's size greater than or equal to the specified value.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "endSize",
               description = "Filters bookDocument's size less than or equal to the specified value.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "content",
               description = "BookDocument content that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "startCreationDate",
               description = "Filters bookDocument's creation date after the specified date. Format: YYYY-MM-DD",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "endCreationDate",
               description = "Filters bookDocument's creation date before the specified date. Format: YYYY-MM-DD",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "startLastModifiedDate",
               description = "Filters bookDocument's last modified date after the specified date. Format: YYYY-MM-DD",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "endLastModifiedDate",
               description = "Filters bookDocument's last modified date before the specified date. Format: YYYY-MM-DD",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "book.id",
               description = "Book id that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "book.startExternalId",
               description = "Filters book's external id greater than or equal to the specified value.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "book.endExternalId",
               description = "Filters book's external id less than or equal to the specified value.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "book.title",
               description = "Book title that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "book.available",
               description = "If TRUE, retrieve only the available BookDocuments; if FALSE, the opposite.",
               content = @Content(schema = @Schema(type = "boolean")))
    @Parameter(in = ParameterIn.QUERY,
               name = "book.startCreatedDateTime",
               description = "Filters book's created date time after the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "book.endCreatedDateTime",
               description = "Filters book's created date time before the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "book.startLastModifiedDateTime",
               description = "Filters book's last modified date time after the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "book.endLastModifiedDateTime",
               description = "Filters book's last modified date time before the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "book.isbn",
               description = "Book isbn that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "author.id",
               description = "Author id that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "author.gender",
               description = "Author gender that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "author.name",
               description = "Author name that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "author.startBirthdate",
               description = "Filters author's birthdate after the specified date. Format: YYYY-MM-DD",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "author.endBirthdate",
               description = "Filters author's birthdate before the specified date. Format: YYYY-MM-DD",
               content = @Content(schema = @Schema(type = "string")))

    @ApiResponses(value = {@ApiResponse(responseCode = HttpStatusConstants.OK_200, description = HttpStatusConstants.OK_200_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.BAD_REQUEST_400, description = HttpStatusConstants.BAD_REQUEST_400_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.UNAUTHORIZED_401, description = HttpStatusConstants.UNAUTHORIZED_401_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.FORBIDDEN_403, description = HttpStatusConstants.FORBIDDEN_403_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.NOT_FOUND_404, description = HttpStatusConstants.NOT_FOUND_404_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.INTERNAL_SERVER_ERROR_500,
                                         description = HttpStatusConstants.INTERNAL_SERVER_ERROR_500_MESSAGE),})

    SearchBookDocumentsWrapperResponse execute(@Parameter(hidden = true) final Pageable pageable, @Parameter(hidden = true) final SearchBookDocumentsRequest request);
}
