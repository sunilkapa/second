package org.sunil.jdbcdemo.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport
{
	public int getCircleCount()
	{
		return this.getJdbcTemplate().queryForInt("SELECT COUNT(*) FROM circle");
	}
}
