package com.soptionssix.data.serviceimpl;

import com.soptionssix.api.dto.MockDto;
import com.soptionssix.data.document.MockDocument;
import com.soptionssix.data.mapper.MockDtoMapper;
import com.soptionssix.data.repository.MockRepository;
import com.soptionssix.domain.service.MockService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteMockService implements MockService {

    private final MockRepository mockRepository;

    @Autowired
    public RemoteMockService(MockRepository mockRepository) {
        this.mockRepository = mockRepository;
    }

    @Override
    public List<MockDto> getAllMockData() {
        List<MockDocument> mockList = mockRepository.findAll();
        return MockDtoMapper.of(mockList);
    }
}
