package com.wishes.demo.service.auth;


import com.wishes.demo.converter.model.EtoMConverter;
import com.wishes.demo.entity.user.UserEntity;
import com.wishes.demo.model.user.UserModel;
import com.wishes.demo.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.wishes.demo.service.auth.dto.UserDetailsDTO;

import java.util.Optional;

@Service
public class AuthService implements UserDetailsService {

    private UserRepository userRepository;
    private EtoMConverter<UserEntity, UserModel> userConverter;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<UserEntity> userOptional = userRepository.findByLogin(username);
        if (userOptional.isPresent()) {
            final UserEntity userEntity = userOptional.get();
            return new UserDetailsDTO(userConverter.convert(userOptional.get()),User.builder()
                    .username(username)
                    .password(userEntity.getPassword())
                    .build());
        }
        throw new UsernameNotFoundException("User with username: " + username + " not found");
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    public void setUserConverter(EtoMConverter<UserEntity, UserModel> userConverter) {
        this.userConverter = userConverter;
    }
}
