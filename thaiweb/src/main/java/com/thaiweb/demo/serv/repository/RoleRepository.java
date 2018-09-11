package com.thaiweb.demo.serv.repository;

import com.thaiweb.demo.serv.domain.RoleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleInfo, Long> {
}
