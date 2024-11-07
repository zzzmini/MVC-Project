package com.my.app.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.my.app.dto.PersonDTO;

@Controller
public class JstlTestController {
	@GetMapping("/jstl/content")
	public String content() {
		return "/jsp-test/content";
	}

	@GetMapping("/jstl/if")
	public String ifTest() {
		return "/jsp-test/if-test";
	}

	@GetMapping("/jstl/choose")
	public String chooseTest(Model model) {
		PersonDTO dto = new PersonDTO("아이유", 20);
		model.addAttribute("dto", dto);
		return "/jsp-test/choose-test";
	}

	@GetMapping("/jstl/foreach")
	public String forEachTest(Model model) {
		PersonDTO dto1 = new PersonDTO("장원영", 20);
		PersonDTO dto2 = new PersonDTO("안유진", 22);
		PersonDTO dto3 = new PersonDTO("이서", 21);
		List<PersonDTO> list = new ArrayList<>();
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);

		model.addAttribute("dto", list);
		return "/jsp-test/for-each-test";
	}
}
