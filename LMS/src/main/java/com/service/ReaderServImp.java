package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advices.ReaderNotFoundException;
import com.advices.UserNotFoundException;
import com.entites.Readers;
import com.entites.Users;
import com.repository.ReadersRepository;
@Service
public class ReaderServImp implements ReaderServ {
@Autowired
ReadersRepository repo;
	@Override
	public Readers register(Readers reader) {
		repo.save(reader);
		return reader;
	}

	@Override
	public Readers updateReaderDetails(Readers reader) {
		int id= reader.getId();
		Readers r1=repo.findById(id).orElseThrow();
		r1.setPassword(reader.getPassword());
		r1.setFirstName(reader.getFirstName());
		r1.setLastName(reader.getLastName());
		r1.setMobileno(reader.getMobileno());
		r1.setEmail(reader.getEmail());
		repo.save(reader);
		return reader;
	}

	@Override
	public String deleteReader(int id) {
		repo.deleteById(id);
		return "deleted";
	}

	@Override
	public List<Readers> viewReadersList() {
		List<Readers> l1= repo.findAll();
		return l1;
	}

	@Override
	public Readers viewReaderById(int id) {
		Readers r1= repo.findById(id).orElseThrow();
		
		return r1;
	}

	@Override
	public Boolean loginValidate(String readerId, String password) throws ReaderNotFoundException {
		boolean flag = false;
		try {
			if (readerId == null && password == null) {
				throw new ReaderNotFoundException("User Details cannot be Empty");
			} else {
				flag = true;
			}
		} catch (Exception e) {
			throw new ReaderNotFoundException("User Details cannot be Empty");
		}
		return flag;
	}

	@Override
	public Readers getPassword(String password) {
		Readers pw=repo.findByPassword(password);
		return pw;
	}

	@Override
	public Readers getMobileno(String mobileno) {
		Readers mbleno=repo.findByMobileno(mobileno);
		return mbleno;
	}

}
