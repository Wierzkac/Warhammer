package com.warhammer.alfa.models.User;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return userRepository.findByEmail(login)
            .or(() -> userRepository.findByNickname(login))
            .orElseThrow(() -> new UsernameNotFoundException("User not found with login: " + login));
    }

    public User findByLogin(String login) {
        return userRepository.findByEmail(login)
            .or(() -> userRepository.findByNickname(login))
            .orElseThrow(() -> new UsernameNotFoundException("User not found with login: " + login));
    }

    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean existsByNickname(String nickname) {
        return userRepository.existsByNickname(nickname);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
}
