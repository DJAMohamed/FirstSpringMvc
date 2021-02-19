package org.eclipse.FirstSpringMvc.dao;

import org.eclipse.FirstSpringMvc.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
}