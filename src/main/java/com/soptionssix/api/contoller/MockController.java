package com.soptionssix.api.contoller;

import com.soptionssix.api.dto.ErrorResponse;
import com.soptionssix.api.dto.MockDto;
import com.soptionssix.domain.error.SoptionsException;
import com.soptionssix.domain.service.MockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mock")
public class MockController {
    private final MockService mockService;

    @Autowired
    public MockController(MockService mockService) {
        this.mockService = mockService;
    }

    @GetMapping("get")
    public List<MockDto> getAllMockData() {
        return mockService.getAllMockData();
    }

    @GetMapping("error/{id}")
    public ErrorResponse throwError(
            @PathVariable("id") String id
    ) {
        if (id.equals("error1")) {
            throw new SoptionsException.Unauthenticated();
        }
        throw new SoptionsException.ExpiredToken();
    }
}
