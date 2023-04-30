package ru.mephi.tasuku.appuser.service;

import java.util.List;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mephi.tasuku.appuser.repository.AppUserRepository;
import ru.mephi.tasuku.appuser.repository.model.AppUserModel;
import ru.mephi.tasuku.appuser.repository.model.SystemRole;
import ru.mephi.tasuku.appuser.service.exception.AppUserByIdNotFoundException;
import ru.mephi.tasuku.appuser.service.exception.AppUserByUsernameNotFoundException;
import ru.mephi.tasuku.appuser.service.exception.AppUserEmailExistsException;
import ru.mephi.tasuku.appuser.service.exception.AppUserUsernameExistsException;
import ru.mephi.tasuku.appuser.service.object.AppUser;

@Service
@RequiredArgsConstructor
public class AppUserService {
    private final AppUserRepository appUserRepository;

    public AppUser getByUsername(String username) {
        AppUserModel appUserModel = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new AppUserByUsernameNotFoundException(username));
        return AppUserModelMapper.modelToObject(appUserModel);
    }

    public AppUser getById(long id) {
        AppUserModel appUserModel = appUserRepository.findById(id)
                .orElseThrow(() -> new AppUserByIdNotFoundException(id));
        return AppUserModelMapper.modelToObject(appUserModel);
    }

    public List<AppUser> getAll() {
        return appUserRepository.findAll().stream()
                .map(AppUserModelMapper::modelToObject)
                .toList();
    }

    @Transactional
    public long create(AppUser appUser) {
        if (isUsernameExists(appUser.getUsername())) {
            throw new AppUserUsernameExistsException(appUser.getUsername());
        }
        if (isEmailExists(appUser.getEmail())) {
            throw new AppUserEmailExistsException(appUser.getEmail());
        }
        AppUserModel appUserModel = AppUserModelMapper.objectToModel(appUser);
        return appUserRepository.save(appUserModel).getId();
    }

    @Transactional
    public void update(AppUser updatedAppUser) {
        AppUser appUser = getById(updatedAppUser.getId());
        String newUsername = updatedAppUser.getUsername();
        if (newUsername != null) {
            if (isUsernameExists(newUsername)) {
                throw new AppUserUsernameExistsException(newUsername);
            }
            appUser.setUsername(newUsername);
        }
        String newEmail = updatedAppUser.getEmail();
        if (newEmail != null) {
            if (isEmailExists(newEmail)) {
                throw new AppUserEmailExistsException(newEmail);
            }
            appUser.setEmail(newEmail);
        }
        String newPassword = updatedAppUser.getPassword();
        if (newPassword != null) {
            appUser.setPassword(newPassword);
        }
        AppUserModel model = AppUserModelMapper.objectToModel(appUser);
        appUserRepository.save(model);
    }

    @Transactional
    public void delete(long appUserId) {
        if (!appUserRepository.existsById(appUserId)) {
            throw new AppUserByIdNotFoundException(appUserId);
        }
        appUserRepository.deleteById(appUserId);
    }

    @Transactional
    public void updateSystemRole(long appUserId, SystemRole systemRole) {
        AppUser appUser = getById(appUserId);
        if (systemRole != null) {
            appUser.setSystemRole(systemRole);
        }
        AppUserModel model = AppUserModelMapper.objectToModel(appUser);
        appUserRepository.save(model);
    }

    private boolean isUsernameExists(String username) {
        return appUserRepository.findByUsername(username).isPresent();
    }

    private boolean isEmailExists(String email) {
        return appUserRepository.findByEmail(email).isPresent();
    }
}
