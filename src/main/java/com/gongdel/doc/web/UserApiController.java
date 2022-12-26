package com.gongdel.doc.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gongdel.doc.domain.UserRequest;
import com.gongdel.doc.domain.UserResponse;
import com.gongdel.doc.model.User;
import com.gongdel.doc.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserApiController {

    private final ObjectMapper mapper;
    private final UserService service;

    @PostMapping("")
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        return ResponseEntity.ok(mapper.convertValue(service.create(request), UserResponse.class));
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> read(@PathVariable("id") Optional<User> user) {
        try {
            return ResponseEntity.ok(
                mapper.convertValue(user.orElseThrow(() -> new NullPointerException()),
                    UserResponse.class));
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("")
    public ResponseEntity<UserResponse> update(@RequestBody UserRequest request) {
        return ResponseEntity.ok(mapper.convertValue(service.update(request), UserResponse.class));
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        boolean result = service.delete(id);
        if (!result) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(null);
    }
}
