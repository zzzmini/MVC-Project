package com.my.app.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.my.app.dto.AdminDTO;
import com.my.app.mapper.AdminMapper;

@Service
public class AdminService {
	private final AdminMapper adminMapper;
	private final PasswordEncoder passwordEncoder;

	public AdminService(AdminMapper adminMapper, PasswordEncoder passwordEncoder) {
		this.adminMapper = adminMapper;
		this.passwordEncoder = passwordEncoder;
	}

	public void adminInsert(AdminDTO adminDTO) {
		if (adminDTO.getA_id().equals("admin")) {
			adminDTO.setA_approval(1);
		} else {
			adminDTO.setA_approval(0);
		}
		adminDTO.setA_pw(passwordEncoder.encode(adminDTO.getA_pw()));
		adminMapper.adminInsert(adminDTO);
	}

	public AdminDTO loginConfirm(AdminDTO adminDTO) {
		AdminDTO dto = adminMapper.loginConfirm(adminDTO);
		return dto;
	}

	public List<AdminDTO> adminList() {
		return adminMapper.adminList();
	}

	public void updateApproval(String id) {
		adminMapper.updateApproval(id);
	}

}
