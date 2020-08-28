package com.indiv.front.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/brd/")
public class boardController {

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list() {
		
		return "board/list";
	}
}