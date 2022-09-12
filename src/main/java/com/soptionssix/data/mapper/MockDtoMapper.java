package com.soptionssix.data.mapper;

import com.soptionssix.api.dto.MockDto;
import com.soptionssix.data.document.MockDocument;

import java.util.List;

public class MockDtoMapper {

    private MockDtoMapper() {
    }

    public static List<MockDto> of(List<MockDocument> mockDocuments) {
        return mockDocuments.stream()
                .map(MockDtoMapper::of)
                .toList();
    }

    public static MockDto of(MockDocument mockDocument) {
        return new MockDto(
                mockDocument.getId(),
                mockDocument.getType(),
                mockDocument.getValue()
        );
    }

}
