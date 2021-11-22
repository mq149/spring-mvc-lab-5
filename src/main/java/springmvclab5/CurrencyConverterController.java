package springmvclab5;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CurrencyConverterController {

	@GetMapping("/convert/{amount}/{exchangeRate}")
	public String convert(@PathVariable float amount, @PathVariable float exchangeRate, Model m) {
		CurrencyConverter cc = new CurrencyConverter(amount, exchangeRate);
		cc.convert();
		m.addAttribute("res", cc.result);
		return "convert";
	}
	
}
