package io.github.jtsato.bookstore.entrypoint.rest.document.api;

import org.springdoc.core.converters.models.PageableAsQueryParam;
import org.springframework.data.domain.Pageable;

import io.github.jtsato.bookstore.entrypoint.rest.document.domain.request.SearchDocumentsRequest;
import io.github.jtsato.bookstore.entrypoint.rest.document.domain.response.SearchDocumentsWrapperResponse;
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

@Tag(name = "Documents")
@FunctionalInterface
public interface SearchDocumentsApiMethod {

    @Operation(summary = "Search Documents")

    @Parameter(name = "Accept-Language",
               example = "pt_BR",
               in = ParameterIn.HEADER,
               description = "Represents a specific geographical, political, or cultural region. Language & Country.")

    @PageableAsQueryParam

    @Parameter(in = ParameterIn.QUERY,
               name = "id",
               description = "Document id that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "number",
               description = "Document number that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "startIssueDate",
               description = "Filters document's issue date after the specified date. Format: YYYY-MM-DD",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "endIssueDate",
               description = "Filters document's issue date before the specified date. Format: YYYY-MM-DD",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "issuer",
               description = "Document issuer that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "state",
               description = "Document state that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "startFrontPhoto",
               description = "Filters document's front photo greater than or equal to the specified value.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "endFrontPhoto",
               description = "Filters document's front photo less than or equal to the specified value.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "startBackPhoto",
               description = "Filters document's back photo greater than or equal to the specified value.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "endBackPhoto",
               description = "Filters document's back photo less than or equal to the specified value.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "startCreatedDateTime",
               description = "Filters document's created date time after the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "endCreatedDateTime",
               description = "Filters document's created date time before the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "startLastModifiedDateTime",
               description = "Filters document's last modified date time after the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "endLastModifiedDateTime",
               description = "Filters document's last modified date time before the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.id",
               description = "Lead id that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.gender",
               description = "Lead gender that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.education",
               description = "Lead education that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.maritalStatus",
               description = "Lead marital status that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.cpf",
               description = "Lead cpf that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.cellphone",
               description = "Lead cellphone that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.name",
               description = "Lead name that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.startBirthdate",
               description = "Filters lead's birthdate after the specified date. Format: YYYY-MM-DD",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.endBirthdate",
               description = "Filters lead's birthdate before the specified date. Format: YYYY-MM-DD",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.motherFullName",
               description = "Lead mother full name that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.stableUnion",
               description = "If TRUE, retrieve only the stable union Documents; if FALSE, the opposite.",
               content = @Content(schema = @Schema(type = "boolean")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.startCreatedDateTime",
               description = "Filters lead's created date time after the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.endCreatedDateTime",
               description = "Filters lead's created date time before the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.startLastModifiedDateTime",
               description = "Filters lead's last modified date time after the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.endLastModifiedDateTime",
               description = "Filters lead's last modified date time before the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.startSelfiePhoto",
               description = "Filters lead's selfie photo greater than or equal to the specified value.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "lead.endSelfiePhoto",
               description = "Filters lead's selfie photo less than or equal to the specified value.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "type.id",
               description = "DocumentType id that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "long")))
    @Parameter(in = ParameterIn.QUERY,
               name = "type.country",
               description = "DocumentType country that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "type.description",
               description = "DocumentType description that need to be considered for filter.",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "type.startCreatedDateTime",
               description = "Filters documentType's created date time after the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "type.endCreatedDateTime",
               description = "Filters documentType's created date time before the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "type.startLastModifiedDateTime",
               description = "Filters documentType's last modified date time after the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))
    @Parameter(in = ParameterIn.QUERY,
               name = "type.endLastModifiedDateTime",
               description = "Filters documentType's last modified date time before the specified datetime. Format: ISO DATETIME",
               content = @Content(schema = @Schema(type = "string")))

    @ApiResponses(value = {@ApiResponse(responseCode = HttpStatusConstants.OK_200, description = HttpStatusConstants.OK_200_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.BAD_REQUEST_400, description = HttpStatusConstants.BAD_REQUEST_400_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.UNAUTHORIZED_401, description = HttpStatusConstants.UNAUTHORIZED_401_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.FORBIDDEN_403, description = HttpStatusConstants.FORBIDDEN_403_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.NOT_FOUND_404, description = HttpStatusConstants.NOT_FOUND_404_MESSAGE),
                           @ApiResponse(responseCode = HttpStatusConstants.INTERNAL_SERVER_ERROR_500,
                                         description = HttpStatusConstants.INTERNAL_SERVER_ERROR_500_MESSAGE),})

    SearchDocumentsWrapperResponse execute(@Parameter(hidden = true) final Pageable pageable, @Parameter(hidden = true) final SearchDocumentsRequest request);
}
