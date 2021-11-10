package com.testcases;


	import static org.assertj.core.api.Assertions.assertThat;
	import static org.junit.jupiter.api.Assertions.*;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

	import org.junit.jupiter.api.Test;
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;

import com.entites.UserAddress;
import com.repository.UserAdressRepository;
import com.service.UserAddressServ;

	
	@SpringBootTest
	class UserAddressServiceImplTest {
		@Autowired
		UserAddressServ useraddservice;
		@MockBean
		UserAdressRepository useraddressrepo;
		@Test
		void testAddUserAddress() {
			UserAddress ua = new UserAddress();
			ua.setAddressId(1);
			ua.setAddress("Venigandla");
			ua.setUsers(null);
			ua.setCity("Guntur");
			ua.setState("Andhra");
			ua.setPincode(522509);
			Mockito.when(useraddressrepo.save(ua)).thenReturn(ua);
			assertThat(useraddservice.addUserAddress(ua)).isEqualTo(ua);
		}

		@Test
		void testUpdateUserAddressDetails() {
			UserAddress ua = new UserAddress();
			ua.setAddressId(1);
			ua.setAddress("Venigandla");
			ua.setUsers(null);
			ua.setCity("Guntur");
			ua.setState("Andhra");
			ua.setPincode(522509);
			
			Optional<UserAddress> b2 =  Optional.of(ua);
			Mockito.when(useraddressrepo.findById(1)).thenReturn(b2);
			Mockito.when(useraddressrepo.save(ua)).thenReturn(ua);
			ua.setAddress("Venigan");
			ua.setUsers(null);
			ua.setCity("Gunt");
			ua.setState("Andh");
			ua.setPincode(522508);
			assertThat(useraddservice.updateUserAddressDetails(ua)).isEqualTo(ua);
		}

		@Test
		void testDeleteUserAddress() {
			UserAddress ua = new UserAddress();
			ua.setAddressId(1);
			ua.setAddress("Venigandla");
			ua.setUsers(null);
			ua.setCity("Guntur");
			ua.setState("Andhra");
			ua.setPincode(522509);
			Optional<UserAddress> b2=Optional.of(ua);
			Mockito.when(useraddressrepo.findById(1)).thenReturn(b2);
			Mockito.when(useraddressrepo.existsById(ua.getAddressId())).thenReturn(false);
			assertFalse(useraddressrepo.existsById(ua.getAddressId()));
		}

		/*
		 * @Test void testViewAddressByUserId() { UserAddress ua = new UserAddress();
		 * ua.setAddressId(1); ua.setAddress("Venigandla"); ua.setUsers(null);
		 * ua.setCity("Guntur"); ua.setState("Andhra"); ua.setPincode(522509);
		 * Optional<UserAddress> c2 = Optional.of(ua);
		 * Mockito.when(useraddressrepo.findById(1)).thenReturn(c2);
		 * assertThat(useraddservice.viewAddressByUserId(1)).isEqualTo(ua); }
		 */
		@Test
		void testViewUserAddressList() {
			UserAddress ua = new UserAddress();
			ua.setAddressId(1);
			ua.setAddress("Venigandla");
			ua.setUsers(null);
			ua.setCity("Guntur");
			ua.setState("Andhra");
			ua.setPincode(522509);
			
			UserAddress ua1 = new UserAddress();
			ua1.setAddressId(1);
			ua1.setAddress("Venig");
			ua1.setUsers(null);
			ua1.setCity("Guntu");
			ua1.setState("Andhr");
			ua1.setPincode(522580);
			
			List<UserAddress> addressList = new ArrayList<UserAddress>();
			addressList.add(ua);
			addressList.add(ua1);
			
			Mockito.when(useraddressrepo.findAll()).thenReturn(addressList);
			assertThat(useraddservice.viewUserAddressList()).isEqualTo(addressList);
		}

		
		  @Test
		  void testGetPinCode() 
		  {  
			  UserAddress ua = new UserAddress();
				ua.setAddressId(1);
				ua.setAddress("Venigandla");
				ua.setUsers(null);
				ua.setCity("Guntur");
				ua.setState("Andhra");
				ua.setPincode(522509);
				Mockito.when(useraddressrepo.findByPincode("522509")).thenReturn(ua);
				assertThat(useraddservice.getPinCode("522509")).isEqualTo(ua);
		  }
		  
			/*
			 * @Test void testGetState() { UserAddress ua = new UserAddress();
			 * ua.setAddressId(1); ua.setAddress("Venigandla"); ua.setUsers(null);
			 * ua.setCity("Guntur"); ua.setState("Andhra"); ua.setPincode(522509);
			 * List<UserAddress> addressList = new ArrayList<UserAddress>();
			 * addressList.add(ua);
			 * Mockito.when(useraddressrepo.findByState("Andhra")).thenReturn(addressList);
			 * assertThat(useraddservice.getState("Andhra")).isEqualTo(addressList); }
			 */

	}


