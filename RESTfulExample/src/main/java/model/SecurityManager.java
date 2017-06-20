package model;
import java.sql.Connection;
import java.util.ArrayList;

import db.DbConnection;
import dto.User;
import dao.UserDao;


public class SecurityManager {

public ArrayList<User> getAllUsersList()throws Exception {

ArrayList<User> userList = new ArrayList<User>();

try {

DbConnection database= new DbConnection();

@SuppressWarnings("static-access")
Connection connection = database.getConnection();

UserDao userdao= new UserDao();

userList= userdao.getAllUsers(connection);



} catch (Exception e) {

throw e;

}

return userList;

}

}