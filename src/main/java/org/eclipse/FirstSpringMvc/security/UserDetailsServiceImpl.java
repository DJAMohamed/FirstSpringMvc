package org.eclipse.FirstSpringMvc.security;

import org.eclipse.FirstSpringMvc.dao.UserRepository;
import org.eclipse.FirstSpringMvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if (null == user) {
			throw new UsernameNotFoundException("No user named " + username);
		} else {
			return new UserDetailsImpl(user);
		}
	}
	
}