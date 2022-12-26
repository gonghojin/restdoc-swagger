package com.gongdel.doc.repository;

import com.gongdel.doc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}