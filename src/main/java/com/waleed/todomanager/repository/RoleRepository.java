package com.waleed.todomanager.repository;

import com.waleed.todomanager.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
