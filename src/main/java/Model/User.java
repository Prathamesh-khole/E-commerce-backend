package Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
//@Table(name = "UserTable")
public class User
{
	 @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     int id;
 	 String name;
 	 String username;
 	 String password;
 	 int accountType;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccountType() {
		return accountType;
	}
	public void setAccountType(int accountType) {
		this.accountType = accountType;
	}
	public User(String name, String username, String password, int accountType) {
		super();
		this.name = name;
		this.username = username;
		this.password = password;
		this.accountType = accountType;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
}
	public User()
	{}
}
