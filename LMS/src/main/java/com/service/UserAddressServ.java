package com.service;

import java.util.List;

import com.entites.UserAddress;

public interface UserAddressServ {
	public UserAddress addUserAddress(UserAddress user);
	public UserAddress updateUserAddressDetails(UserAddress user);
	public String  deleteUserAddress(UserAddress addressId);
	public UserAddress viewAddressByUserId(UserAddress userid);
	public List<UserAddress> viewUserAddressList();
	public UserAddress getPinCode(String pincode);
    public List<UserAddress> getState(String state);

}
