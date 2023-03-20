//package com.prefix.app.readingnote.dto;
//
//import java.time.LocalDate;
//
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
//
//import com.prefix.app.readingnote.domain.Account;
//import com.prefix.app.readingnote.domain.Role;
//
//import lombok.Builder;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//
//@Data
//@RequiredArgsConstructor
//public class AccountSignUpRequestDto {
//	
//    @NotBlank(message = "닉네임을 입력해주세요.")
//    private String nickname;
//	
//    // 이메일을 입력하지 않았을 때 해당 내용을 띄어줌.
//    @NotBlank(message = "이메일을 입력해주세요.")
//    private String email;
//    
//    @NotBlank(message = "비밀번호를 입력해주세요.")
//    // 비밀번호 패턴 지정.
//    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,30}$",
//            message = "비밀번호는 8~30 자리이면서 1개 이상의 알파벳, 숫자, 특수문자를 포함해야합니다.")
//    private String password;
//
//    // 성별을 입력하지 않았을 때 해당 내용을 띄어줌.
//    @NotBlank(message = "성별을 입력해주세요.")
//    private String gender;
//    
//    private LocalDate birthday;
//    
//    private int age;
//    
//    private String created_at;
//    
////    @NotNull(message = "나이를 입력해주세요.")
////    @Range(min = 1, max = 120) // 최소 나이와 최대 나이 지정
////    private int age;
//
//    @Enumerated(EnumType.STRING)
//    private Role role;
//    
//    @Builder
//    public Account toEntity(){
//        return Account.builder()
//        		.nickname(nickname)
//                .email(email)
//                .password(password)
//                .gender(gender)
//                .birthday(birthday)
//                .age(age)
//                .created_at(created_at)
//                .role(Role.yes)
//                .build();
//    }
//}
