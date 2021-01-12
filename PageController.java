import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping(value="/login")
	public String showLoginPage()
	{
		return "Login";
	}
	
	@RequestMapping(value="/register")
	public String showRegisterPage()
	{
		return "Register";
	}
	
	@RequestMapping(value="/contactus")
	public String showContactUS()
	{
		return "ContactUs";
	}
	
	@RequestMapping(value="/aboutus")
	public String showAboutUS()
	{
		return "AboutUs";
	}
	
	@RequestMapping(value="/home")
	public String showIndex()
	{
		return "index";
	}
	
	@RequestMapping(value="/")
	public String showMyRootPage()
	{
		return "index";
	}

}
