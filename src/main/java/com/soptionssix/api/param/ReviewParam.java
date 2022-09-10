package com.soptionssix.api.param;

import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public record ReviewParam(
    @NotNull(message = "region is null")
    String region,
    @NotNull(message = "receipt is null")
    String receipt,
    @Size(max = 300, message = "content size must be between 0 and 300")
    @NotNull(message = "content is null")
    String content,
    @Size(min = 1, max = 2, message = "photo content size must be between 1 and 2")
    List<String> photo
) {

}
