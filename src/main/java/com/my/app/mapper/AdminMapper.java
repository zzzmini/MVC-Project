package com.my.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.my.app.dto.AdminDTO;

@Mapper
public interface AdminMapper {

	void adminInsert(@Param("adminDTO")AdminDTO adminDTO);

	AdminDTO loginConfirm(@Param("adminDTO")AdminDTO adminDTO);

	List<AdminDTO> adminList();

	void updateApproval(String id);

}
