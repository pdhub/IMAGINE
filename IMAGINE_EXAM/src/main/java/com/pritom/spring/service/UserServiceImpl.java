package com.pritom.spring.service;
import java.sql.SQLException;


import com.pritom.spring.dao.UserDao;

public class UserServiceImpl implements UserService

{



  private UserDao userDao;



  public UserDao getUserDao()

  {

        return this.userDao;

 }



 public void setUserDao(UserDao userDao)

 {

     this.userDao = userDao;

 }



 @Override

 public boolean isValidUser(String username, String password) throws SQLException

 {

     return userDao.isValidUser(username, password);

 }



}
