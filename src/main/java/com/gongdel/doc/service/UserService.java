package com.gongdel.doc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gongdel.doc.domain.UserRequest;
import com.gongdel.doc.model.User;
import com.gongdel.doc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final ObjectMapper mapper;
    private final UserRepository repository;

    @Transactional
    public User create(UserRequest request) {
        return repository.save(mapper.convertValue(request, User.class));
    }

    @Transactional
    public User update(UserRequest request) {
        return repository.save(mapper.convertValue(request, User.class));
    }

    @Transactional
    public boolean delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            log.error("user not found!");
            return false;
        }
        return true;
    }
}