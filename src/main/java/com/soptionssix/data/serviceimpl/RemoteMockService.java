package com.soptionssix.data.serviceimpl;

import com.soptionssix.api.dto.MockDto;
import com.soptionssix.data.document.MockDocument;
import com.soptionssix.data.document.ReferenceDocument;
import com.soptionssix.data.mapper.MockDtoMapper;
import com.soptionssix.data.repository.MockRepository;
import com.soptionssix.data.repository.ReferenceRepository;
import com.soptionssix.domain.service.MockService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteMockService implements MockService {

    private final MockRepository mockRepository;
    private final ReferenceRepository referenceRepository;

    @Autowired
    public RemoteMockService(
        MockRepository mockRepository, ReferenceRepository referenceRepository
    ) {
        this.mockRepository = mockRepository;
        this.referenceRepository = referenceRepository;
    }

    @Override
    public List<MockDto> getAllMockData() {
        List<MockDocument> mockList = mockRepository.findAll();
        return MockDtoMapper.of(mockList);
    }

    @Override
    public List<ReferenceDocument> getAllRef() {
        return referenceRepository.findAll();
    }
}
