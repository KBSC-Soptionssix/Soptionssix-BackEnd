package com.soptionssix.domain.service;

import com.soptionssix.api.dto.MockDto;
import com.soptionssix.data.document.ReferenceDocument;
import java.util.List;

public interface MockService {

    List<MockDto> getAllMockData();

    List<ReferenceDocument> getAllRef();

    ReferenceDocument saveRef();
}
