package webservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;





import dto.User;
import exception.ApplicationException;
import model.SecurityManager;
import dao.UserDao;




@Path("/restful")
public class JSONService {



	@POST
	@Path("/log")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response logInJSON(User user) throws SQLException {
		 {

			 String userListData = null;

			 ArrayList<User> userList = new ArrayList<User>();

			 try 

			 {

			 

			 SecurityManager securityManager= new SecurityManager();

			 userList = securityManager.getAllUsersList();

			
			 {

			 System.out.println( "Logged in User");

		

			 }

			 

			} catch (Exception e)

			 {

			 System.out.println("error");

			 }

			 System.out.println("You are not a Valid User");

			 }
		String result = " Login : " + user;
	
		return Response.status(201).entity(result).build();
		
	}
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response regInJSON(User user) throws SQLException {
		
		UserDao.reg(user);
		  ArrayList<User> userList = new ArrayList<User>();
		  
		 	userList.add(user);
		String result = " saved : " + user;
	
		return Response.status(201).entity(result).build();
		
	}


	@PUT
	@Path("/put")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateInJSON(User user) throws SQLException {
		UserDao.update(user);
		ArrayList<User> userList = new ArrayList<User>();
	 	userList.add(user);
		String result = "Updated: " + user;
		return Response.status(201).entity(result).build();
		
	}
	
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response DeleteInJSON(User user) throws ApplicationException, SQLException {
		UserDao.delete(user);
		ArrayList<User> userList = new ArrayList<User>();
	 	userList.add(user);
		String result = "Deleted: " + user;
		return Response.status(201).entity(result).build();
		
	}
	
}