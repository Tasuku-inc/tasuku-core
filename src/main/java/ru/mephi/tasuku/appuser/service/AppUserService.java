package ru.mephi.tasuku.appuser.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.mephi.tasuku.appuser.repository.AppUserRepository;
import ru.mephi.tasuku.appuser.repository.model.AppUserModel;
import ru.mephi.tasuku.appuser.service.object.AppUser;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;
    private final AppUserModelMapper mapper;

    public AppUser findByUsername(String username) {
        AppUserModel appUserModel = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return mapper.modelToObject(appUserModel);
    }
}
