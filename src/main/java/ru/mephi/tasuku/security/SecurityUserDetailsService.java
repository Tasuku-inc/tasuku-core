package ru.mephi.tasuku.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.mephi.tasuku.appuser.repository.AppUserRepository;

@Service
@RequiredArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {
	private final AppUserRepository appUserRepository;

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		var u = appUserRepository.findByUsername(username);
		return u.map(SecurityUser::new)
				.orElseThrow(() -> new UsernameNotFoundException(username));
	}
}
