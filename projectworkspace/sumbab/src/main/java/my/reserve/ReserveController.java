package my.reserve;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReserveController {


	@RequestMapping(value="/reserve", method=RequestMethod.GET)
	public String reserveList() {
		
		return "reserve/reserveList";
	}
	
}
