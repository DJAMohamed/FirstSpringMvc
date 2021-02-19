package org.eclipse.FirstSpringMvc.dao;

import org.eclipse.FirstSpringMvc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	public User findByUserName(String username);
}