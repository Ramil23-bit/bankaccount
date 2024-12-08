package org.example.bankaccount.security;

import org.example.bankaccount.entity.UserBank;
import org.example.bankaccount.service.UserBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserBankService userBankService;

    @Autowired
    private ApplicationContext context;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserBank userBank = userBankService.getByName(username);
        if(userBank == null){
            throw new UsernameNotFoundException("User with login " + username + " not found");
        }
        User user = new User(
                userBank.getLogin(),
                userBank.getPassword(),
                List.of(new SimpleGrantedAuthority(userBank.getRole().name()))
        );
        return user;
    }
}
