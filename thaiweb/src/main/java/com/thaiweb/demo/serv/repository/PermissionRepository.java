package com.thaiweb.demo.serv.repository;

import com.thaiweb.demo.serv.domain.PermissionInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionInfo, Long> {

}
