package com.service;

import java.util.List;

import com.entites.Login;

public interface LoginServ {
	public Login addLoginDetails(Login login);
	public Login updateLoginDetails(Login login) throws Throwable;
	public String deleteLoginDetails(Login loginId);
	public List<Login> viewloginList();
	public Login viewusersbyid(int userid) throws Throwable;
	public List<Login> getByusername(String username);
}
