package com.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.IDNotFoundException;
import com.entites.Login;
import com.repository.LoginRepository;
import com.repository.UsersRepository;
@Service
public class LoginServImp implements LoginServ {
@Autowired
LoginRepository repo;
@Autowired
UsersRepository rep;
	@Override
	public Login addLoginDetails(Login login) {
		return repo.save(login);
	}

	@Override
	public Login updateLoginDetails(Login login) throws Throwable {
		int loginId=login.getLoginId();
		Supplier s1=()->new IDNotFoundException("userId doesnot exist in the database");
		Login l=repo.findById(loginId).orElseThrow(s1);
		l.setLoginId(l.getLoginId());
		l.setUserName(l.getUserName());
		l.setPassword(l.getPassword());
		repo.save(login);
		return login;
	}

	@Override
	public String deleteLoginDetails(Login loginId) {
		repo.delete(loginId);
		return "deleted";
	}

	@Override
	public List<Login> viewloginList() {
		List<Login> l=repo.findAll();
		return l;
	}

	@Override
	public Login viewusersbyid(int userid) throws Throwable {
		Supplier s1=()->new IDNotFoundException("userId doesnot exist in the database");
		Login lm=  repo.findById(userid).orElseThrow(s1);
		return lm;
	}

	@Override
	public List<Login> getByusername(String username) {
		List<Login> u=repo.findByusername(username);
		return u;
	}

}
