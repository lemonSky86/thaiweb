package com.thaiweb.demo.serv.repository;

import com.thaiweb.demo.serv.domain.ManagerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<ManagerInfo, Long> {

    ManagerInfo findManagerInfoByUsernameAndPassword(String username, String password);

    ManagerInfo findManagerInfoByUsername(String username);
}
