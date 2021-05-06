package com.sumbab.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sumbab.project.model.StoreViewService;



@Controller
public class ReserveController {

	@Autowired
	private StoreViewService storeViewService;

	@RequestMapping(value = "/reserve/reserveForm/{storeNum}", method = RequestMethod.GET)
	public String reserve(@PathVariable int storeNum, Model model) {

		model.addAttribute("storelist", storeViewService.readStore(storeNum));// selectOne

		return "reserve/reserveForm";
	}

}
