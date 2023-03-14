//package com.prefix.app.modules.study.endpoint;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.prefix.app.modules.account.domain.entity.Account;
//import com.prefix.app.modules.account.support.CurrentUser;
//import com.prefix.app.modules.study.application.StudyService;
//import com.prefix.app.modules.study.domain.entity.Study;
//import com.prefix.app.modules.study.endpoint.form.StudyForm;
//import com.prefix.app.modules.study.endpoint.form.validator.StudyFormValidator;
//import com.prefix.app.modules.study.infra.repository.StudyRepository;
//
//import javax.validation.Valid;
//import java.net.URLEncoder;
//import java.nio.charset.StandardCharsets;
//
//@Controller
//@RequiredArgsConstructor
//public class StudyController {
//    private final StudyService studyService;
//    private final StudyFormValidator studyFormValidator;
//    private final StudyRepository studyRepository;
//
//    @InitBinder("studyForm")
//    public void studyFormInitBinder(WebDataBinder webDataBinder) {
//        webDataBinder.addValidators(studyFormValidator);
//    }
//
//    @GetMapping("/new-study")
//    public String newStudyForm(@CurrentUser Account account, Model model) {
//        model.addAttribute(account);
//        model.addAttribute(new StudyForm());
//        return "study/form";
//    }
//
//    @PostMapping("/new-study")
//    public String newStudySubmit(@CurrentUser Account account, @Valid StudyForm studyForm, Errors errors) {
//        if (errors.hasErrors()) {
//            return "study/form";
//        }
//        Study newStudy = studyService.createNewStudy(studyForm, account);
//        return "redirect:/study/" + URLEncoder.encode(newStudy.getPath(), StandardCharsets.UTF_8);
//    }
//
//    @GetMapping("/study/{path}")
//    public String viewStudy(@CurrentUser Account account, @PathVariable String path, Model model) {
//        model.addAttribute(account);
//        model.addAttribute(studyService.getStudy(path));
//        return "study/view";
//    }
//
//    @GetMapping("/study/{path}/members")
//    public String viewStudyMembers(@CurrentUser Account account, @PathVariable String path, Model model) {
//        model.addAttribute(account);
//        model.addAttribute(studyService.getStudy(path));
//        return "study/members";
//    }
//
//    @GetMapping("/study/{path}/join")
//    public String joinStudy(@CurrentUser Account account, @PathVariable String path) {
//        Study study = studyRepository.findStudyWithMembersByPath(path);
//        studyService.addMember(study, account);
//        return "redirect:/study/" + study.getEncodedPath() + "/members";
//    }
//
//    @GetMapping("/study/{path}/leave")
//    public String leaveStudy(@CurrentUser Account account, @PathVariable String path) {
//        Study study = studyRepository.findStudyWithMembersByPath(path);
//        studyService.removeMember(study, account);
//        return "redirect:/study/" + study.getEncodedPath() + "/members";
//    }
//}