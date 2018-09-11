package com.thaiweb.demo.serv.repository;

import com.thaiweb.demo.serv.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserInfo, Long> {
}
