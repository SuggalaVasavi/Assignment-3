package dto;

import com.google.gson.Gson;

public class User{

private static final String String = null;
private String password;
private String username;
private String lastname;
private String firstname;
private String email;

public User(){}

public User(String username,String password,String firstname,String lastname,String email) {
	this.username = username;
	this.password = password;
	this.firstname=firstname;
	this.lastname=lastname;
	 this.email=email;
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
 public void setFirstname(String firstname){
	 this.firstname=firstname;
 }
 public String getFirstname(){
	 return firstname;

 }
 public void setLastname(String lastname){
	 this.lastname=lastname;
 }
 public String getLastname(){

	return lastname;
}
 public void setEmail(String email){
	 this.email=email;
 }
 public String getEmail(){
	 return email;
}

@Override
public String toString(){
	
	return "firstname="+getFirstname()+","
			+ "lastname="+getLastname()+","
					+ "email="+getEmail()+""
							+ ","
					+ "username="+getUsername()+""
							+ ","
					+ "password="+getPassword()+"";
}
}
