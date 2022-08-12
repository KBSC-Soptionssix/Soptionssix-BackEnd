package com.soptionssix.api.contoller;

import com.soptionssix.api.dto.MockDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("mock")
public class MockController {
    @GetMapping("get")
    public List<MockDto> getAllMockData() {

    }
}
