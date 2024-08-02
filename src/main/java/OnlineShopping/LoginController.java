package OnlineShopping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Model.LoginReturn;
import Model.User;





@RestController
@CrossOrigin(value="*")
public class LoginController 
{
	@Autowired
	UserRepo userrepo;
	
	@RequestMapping("login")
	public LoginReturn requestMethodName(@RequestBody String sa[])
	{
		System.out.println(sa[0]+"  "+sa[1]);
		if(sa==null)
		   return  new LoginReturn(-1,-1,"Data currpted ");
		
		if(sa[0].length()<1 || sa[0]==null)
			return  new LoginReturn(-1,-1,"Enter username");
		
		if(sa[1].length()<1 || sa[1]==null)
			return  new LoginReturn(-1,-1,"Enter password");
		
		 User user = userrepo.findByUsername(sa[0]);
		 
		 if(user==null)
			 return  new LoginReturn(-1,-1,"Enter valid username");
		 
		 if(user.getPassword().equals(sa[1]))
			 return  new LoginReturn(user.getId(),user.getAccountType(),"present");
		 else
			 return  new LoginReturn(-1,-1,"Encorect password");
	}
}
