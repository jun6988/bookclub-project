package com.prefix.app.readingnote.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prefix.app.readingnote.domain.Account;
import com.prefix.app.readingnote.domain.Role;
import com.prefix.app.readingnote.jwt.JwtToken;
import com.prefix.app.readingnote.jwt.JwtTokenProvider;
import com.prefix.app.readingnote.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {
	
	private final AccountRepository accountRepository;
	private final JwtTokenProvider jwtTokenProvider;
	private final AuthenticationManagerBuilder authenticationManagerBuilder;
	private final RedisTemplate redisTemplate;
	
//	// 회원 가입
//    // readOnly가 true되어있기 때문에 @Transactional을 써줘야 false가 됌.
//    @Transactional
//    public Long signUp(AccountSignUpRequestDto request) throws Exception {
//
//        // 이메일 중복 검사
//        if (accountRepository.findByEmail(request.getEmail()).isPresent()) {
//            throw new Exception("이미 존재하는 이메일 입니다.");
//        }
//        
//		// 현재일자와 생년월일을 이용한 만나이 계산
//		LocalDate birthday = request.getBirthday();
//		LocalDate nowDate = LocalDate.now();
//		request.setAge(nowDate.getYear() - birthday.getYear());
//        Account account = accountRepository.save(request.toEntity());
//
//        return account.getId();
//    }
    
    // JWT 로그인
	public JwtToken login(String email, String password) {
		// 1. Login ID/PW 를 기반으로 Authentication 객체 생성
		// 이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);

		// 2. 실제 검증 (사용자 비밀번호 체크)이 이루어지는 부분
		// authenticate 매서드가 실행될 때 CustomUserDetailsService 에서 만든 loadUserByUsername
		// 메서드가 실행
		Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

		// 3. 인증 정보를 기반으로 JWT 토큰 생성
		JwtToken jwtToken = jwtTokenProvider.generateToken(authentication);

		return jwtToken;
	}
	
	// JWT 로그아웃
	@Transactional
	public void logout(String accessToken) {
		Long expiration = jwtTokenProvider.getExpiration(accessToken);

		redisTemplate.opsForValue().set(accessToken, "blackList", expiration, TimeUnit.MILLISECONDS);
	}
	
    // 회원 조회
	public List<Account> getAccountList() {
		
		return accountRepository.findAll();
	}
	
	// 회원 개별 조회
	public Optional<Account> getAccountListById(Long id) {
		
		return accountRepository.findById(id);
	}
	
	// 회원가입
	public Account join(Account account) {
		
		account.setRole(Role.user);
		
		// 작성일자 문자열 변경
		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		
		account.setCreated_at(nowDateTime.format(formatter));
		
		// 현재일자와 생년월일을 이용한 만나이 계산
		LocalDate birthday = account.getBirthday();
		LocalDate nowDate = LocalDate.now();
		
		account.setAge(nowDate.getYear() - birthday.getYear());
		
		return accountRepository.save(account);
	}
	
	// 회원정보 수정
	public Account updateAccount(Account account) {
		
		account.setRole(Role.user);
		
		// 작성일자 문자열 변경
		LocalDateTime nowDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		
		account.setCreated_at(nowDateTime.format(formatter));
		
		// 현재일자와 생년월일을 이용한 만나이 계산
		LocalDate birthday = account.getBirthday();
		LocalDate nowDate = LocalDate.now();
		
		account.setAge(nowDate.getYear() - birthday.getYear());
		
		return accountRepository.save(account);
	}
	
	// 회원 삭제
	public void removeAccount(Long id) {
		
		accountRepository.deleteById(id);
	}
        
}
