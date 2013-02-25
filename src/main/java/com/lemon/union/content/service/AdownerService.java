package com.lemon.union.content.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemon.union.content.dto.AdownerDTO;
import com.lemon.union.dao.AdownerDAO;

@Service
public class AdownerService {

	@Autowired
	AdownerDAO dao;

	public List<AdownerDTO> list() {
		return dao.list();
	}

	public void create(String name, String company, String brief, int status) {
		dao.create(name, company, brief, status);
	}

	public void update(long id, String name, String company, String brief,
			int status) {
		dao.update(id, name, company, brief, status);
	}

	public void delete(long id) {
		dao.delete(id);
	}

	public AdownerDTO show(long id) {
		return dao.show(id);
	}
}
