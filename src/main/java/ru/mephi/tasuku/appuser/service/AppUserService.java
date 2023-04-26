package ru.mephi.tasuku.appuser.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mephi.tasuku.appuser.repository.AppUserRepository;
import ru.mephi.tasuku.appuser.repository.model.AppUserModel;
import ru.mephi.tasuku.appuser.repository.model.SystemRole;
import ru.mephi.tasuku.appuser.service.exception.AppUserByIdNotFoundException;
import ru.mephi.tasuku.appuser.service.exception.AppUserEmailExistsException;
import ru.mephi.tasuku.appuser.service.exception.AppUserUsernameExistsException;
import ru.mephi.tasuku.appuser.service.object.AppUser;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService {
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public AppUser getByUsername(String username) {
        AppUserModel appUserModel = appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        return AppUserModelMapper.modelToObject(appUserModel);
    }

    public AppUser getById(long id) {
        AppUserModel appUserModel = appUserRepository.findById(id)
                .orElseThrow(() -> new AppUserByIdNotFoundException(id));
        return AppUserModelMapper.modelToObject(appUserModel);
    }

	public List<AppUser> getAll() {
        return appUserRepository.findAll().stream()
                .map(AppUserModelMapper::modelToObject).toList();
	}

    @Transactional
    public long create(AppUser appUser) {
        if (isUsernameOccupied(appUser.getUsername())) {
            throw new AppUserUsernameExistsException(appUser.getUsername());
        }
        if (isEmailOccupied(appUser.getEmail())) {
            throw new AppUserEmailExistsException(appUser.getEmail());
        }
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        AppUserModel appUserModel = AppUserModelMapper.objectToModel(appUser);
        return appUserRepository.save(appUserModel).getId();
    }

    @Transactional
    public void update(long appUserId, AppUser updatedAppUser) {
        AppUser oldAppUser = this.getById(appUserId);
        String oldUsername = oldAppUser.getUsername();
        String updatedUsername = updatedAppUser.getUsername();
        String oldEmail = oldAppUser.getEmail();
        String updatedEmail = updatedAppUser.getEmail();
        if (!oldUsername.equals(updatedUsername)
                && isUsernameOccupied(updatedUsername)) {
            throw new AppUserUsernameExistsException(updatedUsername);
        }
        if (!oldEmail.equals(updatedEmail)
                && isEmailOccupied(updatedEmail)) {
            throw new AppUserEmailExistsException(updatedEmail);
        }

        updatedAppUser.setId(appUserId);
        appUserRepository.save(
                AppUserModelMapper.objectToModel(updatedAppUser)
        );
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
        AppUser appUser = this.getById(appUserId);
        appUser.setSystemRole(systemRole);
        appUserRepository.save(
                AppUserModelMapper.objectToModel(appUser)
        );
    }

    private boolean isUsernameOccupied(String username) {
        return appUserRepository.findByUsername(username).isPresent();
    }

    private boolean isEmailOccupied(String email) {
        return appUserRepository.findByEmail(email).isPresent();
    }
}
