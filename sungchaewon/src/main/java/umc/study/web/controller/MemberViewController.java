//package umc.study.web.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import umc.study.service.MemberService.MemberCommandService;
//import umc.study.web.dto.MemberRequestDTO;
//
//@Controller
//public class MemberViewController {
//
//    private final MemberCommandService memberCommandService;
//
//    public MemberViewController(MemberCommandService memberCommandService) {
//        this.memberCommandService = memberCommandService;
//    }
//
//    // thymeleaf 사용을 위해 일부가 변경되었습니다.
//    // 실제로는 8주차에서 작성한 컨트롤러와 동일하게 작성하시면 됩니다!!
//    @PostMapping("/members/signup")
//    public String joinMember(@ModelAttribute("memberJoinDto") MemberRequestDTO.JoinDto request, // 협업시에는 기존 RequestBody 어노테이션을 붙여주시면 됩니다!
//                             BindingResult bindingResult,
//                             Model model) {
//        System.out.println("✅ joinMember 컨트롤러 진입");
//
//        if (bindingResult.hasErrors()) {
//            System.out.println("❌ BindingResult 오류 발생");
//            // 뷰에 데이터 바인딩이 실패할 경우 signup 페이지를 유지합니다.
//            return "signup";
//        }
//
//        try {
//            System.out.println("📤 MemberCommandService로 회원가입 요청 전송");
//            memberCommandService.joinMember(request);
//            return "redirect:/login";
//        } catch (Exception e) {
//            System.out.println("❗ 회원가입 예외 발생: " + e.getMessage());
//            // 회원가입 과정에서 에러가 발생할 경우 에러 메시지를 보내고, signup 페이디를 유지합니다.
//            model.addAttribute("error", e.getMessage());
//            return "signup";
//        }
//    }
//
//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }
//
//    @GetMapping("/members/signup")
//    public String signupPage(Model model) {
//        model.addAttribute("memberJoinDto", new MemberRequestDTO.JoinDto());
//        return "signup";
//    }
//
//    @GetMapping("/home")
//    public String home() {
//        return "home";
//    }
//
//    @GetMapping("/admin")
//    public String admin() {
//        return "admin";
//    }
//}
