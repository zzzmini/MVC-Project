package com.my.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.my.app.dto.AdminDTO;
import com.my.app.service.AdminService;

@Controller
public class AjaxController {
	private final AdminService adminService;
	public AjaxController(AdminService adminService) {
		this.adminService = adminService;
	}
	
	@PostMapping("/goTest")
	@ResponseBody
	public Map<String, String> goTest(@RequestBody
			Map<String, String> body){
		String keyword = body.get("player");
		System.out.println("player : " + keyword);
		body.put("goal", "100");
		return body;
	}
	
	@PostMapping("/searchData")
	@ResponseBody
	public List<AdminDTO> getList(){
		List<AdminDTO> adminDtos = adminService.searchData();
		return adminDtos;
	}
}
