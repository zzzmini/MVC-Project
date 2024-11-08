package com.my.app.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.my.app.dto.AdminDTO;

@Mapper
public interface AdminMapper {

	void adminInsert(@Param("adminDTO")AdminDTO adminDTO);

	AdminDTO loginConfirm(@Param("adminDTO")AdminDTO adminDTO);

	List<AdminDTO> adminList();

	void updateApproval(String id);

	List<AdminDTO> pagingList(Map<String, Integer> pagingParams);

	int boardCount();

}
