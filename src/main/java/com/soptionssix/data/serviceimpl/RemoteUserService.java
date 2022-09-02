package com.soptionssix.data.serviceimpl;

import com.soptionssix.api.dto.UserDto;
import com.soptionssix.data.document.User;
import com.soptionssix.data.repository.UserRepository;
import com.soptionssix.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoteUserService implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public RemoteUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean hasUser(String userId) {
        return this.userRepository.existsById(userId);
    }
}
