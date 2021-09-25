package com.chris.sso.demo.user.server;


import com.chris.sso.demo.user.dao.UserRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<com.chris.sso.demo.user.entity.User> user = userRepository.findByName(username).stream().findFirst();
        String password = StringUtils.EMPTY;
        if (!ObjectUtils.isEmpty(user)) {
            password = user.get().getPassword();
        }

        return new User(username, passwordEncoder.encode(password), AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }
}
