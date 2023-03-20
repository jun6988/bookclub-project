package com.prefix.app.readingnote.jwt;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.prefix.app.readingnote.domain.Account;
import com.prefix.app.readingnote.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SecurityUserDetailService implements UserDetailsService {

	
	private final AccountRepository accountRepository;
	private final PasswordEncoder passwordEncoder;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository.findByEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저를 찾을 수 없습니다."));
    }
    
    // 해당하는 User 의 데이터가 존재한다면 UserDetails 객체로 만들어서 리턴
    private UserDetails createUserDetails(Account account) {
        return User.builder()
                .username(account.getUsername())
                .password(passwordEncoder.encode(account.getPassword()))
                .roles(account.getRole().toString())
                .build();
    }
}
