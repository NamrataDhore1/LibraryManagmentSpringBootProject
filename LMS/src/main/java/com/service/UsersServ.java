package com.service;

import java.util.List;
import java.util.Optional;

import com.entites.Users;

public interface UsersServ {
	public Users registerUserDetails(Users user);
	public Users loginValidate(Users user) throws Throwable;
	//public Users cancelSubscription(Users user);
	//public int payThePenalty(int userid, double amount);
	public List<Users> viewAllUsers();
	public Users updateUserDetails(Users user);
	public Users deleteUserDetails(Users user);
    public Users getEmail(String email);
	public Users getMobileno(String mobileno);

}
