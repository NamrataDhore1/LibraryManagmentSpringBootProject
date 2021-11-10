package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entites.UserAddress;
import com.repository.UserAdressRepository;

@Service
public class UserAddressServImp implements UserAddressServ  {

	@Autowired 
	UserAdressRepository repo;
	@Override
	public UserAddress addUserAddress(UserAddress user) {
		 repo.save(user);
		 return user;
	}

	@Override
	public UserAddress updateUserAddressDetails(UserAddress user) {
		int userid= user.getAddressId();
		UserAddress a1 = repo.findById(userid).orElseThrow();
			a1.setAddress(user.getAddress());
			a1.setAddressId(user.getAddressId());
			a1.setCity(user.getCity());
			a1.setPincode(user.getPincode());
			a1.setState(user.getState());
			a1.setUsers(user.getUsers());
			repo.save(user);
			return a1;
	}

	@Override
	public String deleteUserAddress(UserAddress addressId) {
		repo.delete(addressId);
		return "Deleted";
	
	}

	@Override
	public UserAddress viewAddressByUserId(UserAddress userid) {
		repo.delete(userid);
		 return userid;
	}

	@Override
	public List<UserAddress> viewUserAddressList() {
		List<UserAddress> l2 = repo.findAll();
		return l2;
	}

	@Override
	public UserAddress getPinCode(String pincode) {
		UserAddress pin = repo.findByPincode(pincode);
		return pin;
	}

	@Override
	public List<UserAddress> getState(String state) {
		List<UserAddress> st=repo.findAll();
		return st;
	}

}
