package com.soptionssix.api.contoller;

import com.soptionssix.api.dto.StoreDto;
import com.soptionssix.domain.service.StoreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("store")
public class StoreController {
    private final StoreService storeService;


    @Autowired
    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("")
    public ResponseEntity<List<StoreDto>> getAllStore(){
        List<StoreDto> storeDtoList = storeService.getAllStore();
        return ResponseEntity.ok(storeDtoList);
    }
}
