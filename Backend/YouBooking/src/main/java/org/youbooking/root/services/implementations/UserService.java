package org.youbooking.root.services.implementations;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.youbooking.root.entities.AppUser;
import org.youbooking.root.enums.AvailabilityStateEnum;
import org.youbooking.root.repositories.UserRepository;
import org.youbooking.root.services.interfaces.UserServiceInterface;

import java.util.List;


@Service @RequiredArgsConstructor
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;

    @Override
    public List<AppUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override @Transactional
    public AppUser saveUser(AppUser user) {
       return userRepository.save(user);
    }

    @Override @Transactional
    public AppUser banUser(Long userId) {
        AppUser user = userRepository.findById(userId).orElse(null);

        if(user == null)
            return null;

        user.setStatus(AvailabilityStateEnum.BANNED);
        return userRepository.save(user);
    }

    @Override @Transactional
    public AppUser unBanUser(Long userId) {
       AppUser user = userRepository.findById(userId).orElse(null);

       if(user == null)
           return null;

       user.setStatus(AvailabilityStateEnum.ONLINE);
       return userRepository.save(user);
    }

    @Override
    public AppUser findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public boolean isUsernameAlreadyExists(String username) {
        AppUser user = findUserByUsername(username);
        return user != null;
    }
}
