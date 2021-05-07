package com.sumbab.sumbab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sumbab.sumbab.model.search.SearchService;

@Controller
public class SearchController {
	
	@Autowired
	private SearchService searchService;
	
	@Autowired
	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}

	// store.classify 선택 후(음식점/카페) ---> 메인 검색창
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search() {
		return "/search/searchBar";
	}

	@RequestMapping(value = "/selectByInput", method = RequestMethod.POST)
	public String selectListByInput(@ModelAttribute("input") String input, Model model) {
		
		if(input.contains("#")) {
			String inputT = input.substring(1);
			System.out.println(inputT);
			model.addAttribute("storeList", searchService.selectByTag(inputT));
		}else {
			model.addAttribute("storeList", searchService.selectByKeyword(input));
		}
		
		return "/search/selectByInput";
	}
	
	@RequestMapping(value="/selectByTag/{tagName}", method = RequestMethod.GET)
	public String clickHashtag(@PathVariable @ModelAttribute("input")String tagName, Model model) {
		model.addAttribute("storeList", searchService.selectByTag(tagName));
		
		return "/search/selectByInput";
	}
}
