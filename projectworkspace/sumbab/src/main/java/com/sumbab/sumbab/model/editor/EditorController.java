package com.sumbab.sumbab.model.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditorController {

	@Autowired
	private EditorService editorService;
	
	@RequestMapping(value="/editor/getAllStore", method=RequestMethod.GET)
	public String createList(@ModelAttribute("setList")Editor editor,Model model) {
		
		model.addAttribute("setList", new Editor());
		model.addAttribute("storeList", editorService.getAllStore());
		
		return "/editor/getAllStore";
	}
}
