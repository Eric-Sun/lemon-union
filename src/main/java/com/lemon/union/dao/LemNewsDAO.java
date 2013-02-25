package com.lemon.union.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lemon.union.content.dto.LemNewsDTO;

@Repository
public class LemNewsDAO {

	@Autowired
	JdbcTemplate j;

	public List<LemNewsDTO> list(int pageNum, int pageSize) {
		String sql = "select * from lem_news limit " + pageSize + ","
				+ (pageNum - 1) * pageSize;
		return j.query(sql, new Object[] {}, new BeanPropertyRowMapper(
				LemNewsDTO.class));
	}

	public LemNewsDTO get(long id) {
		String sql = "select * from lem_news where id=?";
		List<LemNewsDTO> list = j.query(sql, new Object[] { id },
				new BeanPropertyRowMapper(LemNewsDTO.class));
		if (list == null || list.size() == 0) {
			return null;
		} else
			return list.get(0);
	}

	public void delete(long id) {
		String sql = "delete from lem_news where id=?";
		j.update(sql, new Object[] { id });
	}

	public void create(String catalogid, String classid, String title,
			String brief, String content, String orign, String editor,
			String link) {
		String sql = "insert into lem_news (catalogid,classid,title,brief,content,createtime,"
				+ "orign,editor,link) values (?,?,?,?,?,now(),?,?,?)";
		j.update(sql, new Object[] { catalogid, classid, title, brief, content,
				orign, editor, link });
	}

	public void update(long id, String catalogid, String classid, String title,
			String brief, String content, String orign, String editor,
			String link) {
		String sql = "update lem_news set catalogid=?,classid=?, title=?,brief=?,content=?,modifytime=now(),"
				+ "orign = ?,editor=?,link=? where id=?";

		j.update(sql, new Object[] { catalogid, classid, title, brief, content,
				id, orign, editor, link });
	}

	public LemNewsDTO show(int id) {
		String sql = "select * from lem_news where id=?";
		return (LemNewsDTO) j.query(sql, new Object[] { id },
				new BeanPropertyRowMapper(LemNewsDTO.class)).get(0);
	}

}
