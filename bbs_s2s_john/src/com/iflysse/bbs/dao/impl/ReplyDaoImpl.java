package com.iflysse.bbs.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.iflysse.bbs.dao.ReplyDao;
import com.iflysse.bbs.model.ReplyInfo;



@Repository("reployDao")
public class ReplyDaoImpl implements ReplyDao {
	@Resource
	private DataSource dataSource;
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}


	@Override
	public boolean add(ReplyInfo reply) {
		// TODO Auto-generated method stub
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		boolean flag = false;
		String sql = "insert into XXOAF_reply (content,create_date,userid,newsid) values(?,?,?,?)";
		Object[] params = new Object[] { reply.getContent(),
				reply.getCreate_date(), reply.getUserid(), reply.getNewsid() };
		try {
			int row = jt.update(sql, params);
			flag = row > 0 ? true : false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public List<ReplyInfo> getReplyListByNewsId(int newsId) {
		// TODO Auto-generated method stub
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		List<ReplyInfo> list = null;
		String sql = "select r.* ,u.name as username from XXOAF_reply r  left join XXOAF_user u on r.userid=u.id  where  newsid = ?  ";
		try {
			list = jt.query(sql, new BeanPropertyRowMapper<ReplyInfo>(
					ReplyInfo.class), newsId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteByNewsId(int newsId) {
		// TODO Auto-generated method stub
		JdbcTemplate jt= new JdbcTemplate(dataSource);
		boolean flag = false;
		String sql = "delete from XXOAF_reply where newsId = ?";
		try {
			int row = jt.update(sql, newsId);
			flag = row > 0 ? true : false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
