package ru.mephi.tasuku.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.mephi.tasuku.appuser.repository.AppUserRepository;
import ru.mephi.tasuku.appuser.repository.model.AppUserModel;
import ru.mephi.tasuku.appuser.service.AppUserModelMapper;
import ru.mephi.tasuku.appuser.service.AppUserService;
import ru.mephi.tasuku.appuser.service.object.AppUser;

@Service
@RequiredArgsConstructor
public class SecurityUserDetailsService implements UserDetailsService {
    private final AppUserService appUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserService.findByUsername(username);
        return new SecurityUser(appUser);
    }
}
