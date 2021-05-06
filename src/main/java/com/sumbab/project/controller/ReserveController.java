package com.sumbab.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sumbab.project.stroreviewservice.StoreViewService;

@Controller
public class ReserveController {

	@Autowired
	private StoreViewService storeViewService;

	@RequestMapping(value = "/reserve/reserveForm/{store_num}", method = RequestMethod.GET)
	public String reserve(@PathVariable int store_num, Model model) {

		model.addAttribute("storelist", storeViewService.readStore(store_num));// selectOne

		return "reserve/reserveForm";
	}

}
