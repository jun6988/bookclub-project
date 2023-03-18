//package com.prefix.app.readingnote.controller;
//
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.apache.catalina.security.SecurityUtil;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.prefix.app.readingnote.domain.Account;
//import com.prefix.app.readingnote.repository.AccountRepository;
//import com.prefix.app.readingnote.service.AccountService;
//import com.project.security.jwt.JwtToken;
//import com.project.security.jwt.JwtTokenProvider;
//
//import lombok.RequiredArgsConstructor;
//
//@RestController
//@RequestMapping("/account")
//@RequiredArgsConstructor
//public class AccountController {
//	
//	private final AccountRepository accountRepository;
//	private final AccountService accountService;
//	private final PasswordEncoder passwordEncoder;
//	private final JwtTokenProvider jwtTokenProvider;
//	
////	// 회원가입
////	@PostMapping("/join")
////    public Long singUp(@Valid @RequestBody AccountSignUpRequestDto request) throws Exception {
////		return accountService.signUp(request);
////    }
////	
//	// JWT 로그인
//	@PostMapping("/login")
//	@CrossOrigin(origins = "*", exposedHeaders = "Authorization")
//	public JwtToken Login(@RequestBody Map<String, String> user) {
//		Account account = accountRepository.findByEmail(user.get("email"))
//						.orElseThrow(() -> new IllegalArgumentException("가입 되지 않은 아이디 입니다."));
//		if (!(user.get("password").equals(account.getPassword()))) {
//			throw new IllegalArgumentException("아이디 또는 비밀번호가 맞지않습니다.");
//		}
//		JwtToken jwtToken = accountService.login(account.getEmail(), account.getPassword());
//		return jwtToken;
//	}
//	
//	// JWT 로그아웃
//	@PostMapping("/logout")
//	public ResponseEntity<Void> logout(@RequestHeader("Authorization") String accessToken) {
//		accountService.logout(accessToken);
//		System.out.println("로그아웃성공");
//		return new ResponseEntity(HttpStatus.OK);
//	}
//	
//	// 권한 Test
//	@PostMapping("/yes/test")
//	public String test() {
//		System.out.println("@@@" + SecurityContextHolder.getContext().getAuthentication().getName() + "@@@");
//		System.out.println("email: " + SecurityUtil.getCurrentAccountEmail());
//		return "Test 성공";
//	}
//	
//	// 사용자 조회
//	@GetMapping("/list")
//	public List<Account> getAccount(Account account) {
//		
//		return accountService.getAccountList();
//	}
//	
//	// 사용자 개별 조회
//	@GetMapping("/list/{id}")
//	public Optional<Account> getAccountById(@PathVariable("id") Long id) {
//		
//		return accountService.getAccountListById(id);
//	}
//	
//	// 회원가입
//	@CrossOrigin(origins = "*")
//	@PostMapping("/join")
//	public Account join(@RequestBody Account account) {
//		
//		return accountService.join(account);
//	}
//	
//	// 회원정보 수정
//	@PutMapping("/update/{id}")
//	public void updateAccount(
//			@PathVariable("id") Long id,
//			@RequestBody Account account) {
//		
//		accountService.updateAccount(account);
//	}
//	
//	// 사용자 삭제
//	@DeleteMapping("/delete/{id}")
//	public void removeAccount(@PathVariable Long id) {
//		
//		accountService.removeAccount(id);
//	}
//	
//}
