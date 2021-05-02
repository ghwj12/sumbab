package store.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/selectByKeyword", method = RequestMethod.POST)
	public String selectListByInput(@ModelAttribute("input") String input, Model model) {

		//검색어를 통하여 select된 list 반환
		model.addAttribute("storeList", searchService.selectList(input));
		
		return "/search/selectByKeyword";
	}
}
