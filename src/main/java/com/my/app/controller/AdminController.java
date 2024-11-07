package com.my.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.my.app.dto.AdminDTO;
import com.my.app.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private final AdminService adminService;
	private final PasswordEncoder passwordEncoder;
	public AdminController(AdminService adminService,
			PasswordEncoder passwordEncoder) {
		this.adminService = adminService;
		this.passwordEncoder = passwordEncoder;
	}
	
	@GetMapping("")
	public String mainView() {
		return "/admin/main";
	}
	
	@GetMapping("loginForm")
	public String loginFormView() {
		return "/admin/loginForm";
	}
	@GetMapping("createAccountForm")
	public String accountFormView() {
		return "/admin/accountForm";
	}
	@PostMapping("createAccountConfirm")
	public String insertAdminAccount(AdminDTO adminDTO) {
		System.out.println(adminDTO);
		adminService.adminInsert(adminDTO);
		return "/admin/admin-list";
	}
	
	@PostMapping("loginConfirm")
	public String loginConfirm(AdminDTO adminDTO,
			HttpSession session) {
		String nextPage = "/admin/login_ok";
		AdminDTO adminLoginedDto = adminService.loginConfirm(adminDTO);
		if(ObjectUtils.isEmpty(adminLoginedDto)) {
			nextPage = "/admin/login_ng";
		} else {
			// 비밀번호 확인
			if(! passwordEncoder.matches(adminDTO.getA_pw(), adminLoginedDto.getA_pw())) {
				nextPage = "/admin/login_ng";
			} else {
				// 로그인 정상 성공
				session.setAttribute("adminLoginedDto",adminLoginedDto);
				session.setMaxInactiveInterval(60*30); // 30분
				return nextPage;
			}
		}
		return nextPage;
	}
	
	@GetMapping("logoutConfirm")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/admin";
	}
	
	@GetMapping("adminList")
	public String adminList(Model model) {
		List<AdminDTO> list = adminService.adminList();
		model.addAttribute("list", list);
		return "/admin/admin-list";
	}
	@GetMapping("setAdminApproval")
	public String setAdminApproval(@RequestParam("id")String id) {
		adminService.updateApproval(id);
		return "redirect:/admin/adminList";
	}
}









