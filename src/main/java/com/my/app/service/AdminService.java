package com.my.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.StyledEditorKit.BoldAction;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.my.app.dto.AdminDTO;
import com.my.app.dto.PageDTO;
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

	public void createAccountData() {

	}
	
	int pageLimit = 3;  // 한 페이지에 보여줄 글의 갯수
	int blockLimit = 3; // 하단 페이지 리스트의 번호 갯수
	public List<AdminDTO> pagingList(int page) {
		// 1페이지당 보여질 글 갯수 : 3개
		// 1page => 0
		// 2page => 3
		// 3page ==> 6
		int pagingStart = (page - 1) * pageLimit;
		Map<String, Integer> pagingParams = new HashMap<>();
		pagingParams.put("start", pagingStart);
		pagingParams.put("limit", pageLimit);
		List<AdminDTO> pagingList = adminMapper.pagingList(pagingParams);
		return pagingList;
	}

	public PageDTO getPagingInfo(int page) {
		// 전체 글 갯수 조회
		int boardCount = adminMapper.boardCount();
		// 전체 페이지 갯수 계산(10/3 = 3.3333 => 4page)
		int maxPage = (int)(Math.ceil((double)boardCount / pageLimit));
		
		// 시작페이지 값 계산(1, 4, 7, ...  한번에 보여줄 페이지수가 3일때)
		int startPage = (((int)Math.ceil((double)page / blockLimit))-1)
					* blockLimit + 1;
		
		// 끝 페이지 값 계산
		int endPage = startPage + blockLimit - 1 ;
		
		if(endPage > maxPage) endPage = maxPage;
		
		PageDTO pageDTO = new PageDTO();
		pageDTO.setPage(page);
		pageDTO.setMaxPage(maxPage);
		pageDTO.setStartPage(startPage);
		pageDTO.setEndPage(endPage);
		return pageDTO;
	}

	public List<AdminDTO> searchAdmin(String id) {
		
		return adminMapper.searchAdmin(id); 
	}

	public List<AdminDTO> searchData() {
		return adminMapper.searchData();
	}

}











