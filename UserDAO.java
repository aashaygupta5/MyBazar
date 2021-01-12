package com.niit.DAO;

import com.niit.Model.UserDetail;

public interface UserDAO {

	public boolean registerUserDetail(UserDetail userDetail);
	public boolean updateUserDetail(UserDetail userDetail);
	public boolean deleteUserDetail(UserDetail userDetail);
	
	public UserDetail getUserDetail(String username);
	
}
