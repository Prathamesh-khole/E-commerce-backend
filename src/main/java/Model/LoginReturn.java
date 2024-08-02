package Model;

public class LoginReturn 
{
	 int userid;
     int accounttype;
     String errorMessage;
     
     
     public LoginReturn(int id, int accounttype, String errorMessage)
     {
 		super();
 		this.userid = id;
 		this.accounttype = accounttype;
 		this.errorMessage = errorMessage;
 	 }
     
     
	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}


	public int getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(int accounttype) {
		this.accounttype = accounttype;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String toString() {
		return "LoginReturn [id=" + userid + ", accountType=" + accounttype + ", errorMessage=" + errorMessage + "]";
	}
}
