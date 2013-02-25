package com.lemon.union.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lemon.union.content.dto.AdownerDTO;

@Repository
public class AdownerDAO {

	@Autowired
	JdbcTemplate j;

	public List<AdownerDTO> list() {
		String sql = "select * from lem_adowner";
		return j.query(sql, new Object[] {}, new BeanPropertyRowMapper(
				AdownerDTO.class));
	}

	public void create(String name, String company, String brief, int status) {
		String sql = "insert into lem_adowner (name,company,brief,status,createtime) values (?,?,?,?,now())";
		j.update(sql, new Object[] { name, company, brief, status });
	}

	public void update(long id, String name, String company, String brief,
			int status) {
		String sql = "update lem_adowner set name=?,company=?,brief=?,status=? where id=?";
		j.update(sql, new Object[] { name, company, brief, status, id });
	}

	public void delete(long id) {
		String sql = "delete from lem_adowner where id=?";
		j.update(sql, new Object[] { id });
	}

	public AdownerDTO show(long id){
		String sql = "select * from lem_adowner where id=?";
		return (AdownerDTO)j.query(sql, new Object[] {id}, new BeanPropertyRowMapper(
				AdownerDTO.class)).get(0);
	}
}
