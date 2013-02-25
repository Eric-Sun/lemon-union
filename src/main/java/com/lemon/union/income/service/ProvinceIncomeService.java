package com.lemon.union.income.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lemon.union.income.dto.ProvinceIncomeDTO;

@Service
public class ProvinceIncomeService {

	public List<ProvinceIncomeDTO> query(Date beginDate, Date endDate) {
		List<ProvinceIncomeDTO> returnList = new ArrayList<ProvinceIncomeDTO>();

		return returnList;
	}

}
