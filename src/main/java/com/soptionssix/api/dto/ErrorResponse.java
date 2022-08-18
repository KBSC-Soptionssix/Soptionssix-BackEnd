package com.soptionssix.api.dto;

import javax.validation.constraints.NotNull;

public record ErrorResponse(@NotNull int status, String message) {
}
