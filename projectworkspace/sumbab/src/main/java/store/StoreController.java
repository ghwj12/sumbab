package store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StoreController {

	@RequestMapping(value="/registerStore")
	public String regitStore() {
		return "/store/registerStore";
	}
	
}
