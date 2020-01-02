package org.sunil.jdbcdemo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import org.sunil.jdbcdemo.model.Circle;

@Component
public class JdbcImpl 
{
	
	private DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	NamedParameterJdbcTemplate namedJdbcTemplate;
	public DataSource getDataSource() {
		return dataSource;
	}
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@SuppressWarnings("deprecation")
	public int getCircleCount()
	{
		String sql = "SELECT COUNT(*) FROM circle";
		return jdbcTemplate.queryForInt(sql);
	}
	
	public String getCircleName(int circleId)
	{
		return jdbcTemplate.queryForObject("SELECT name FROM circle WHERE id=?",new Object[] {circleId}, String.class);
	}
	
	public Circle getCircleForId(int circleId)
	{
		return jdbcTemplate.queryForObject("SELECT * FROM circle WHERE id=?", new Object[] {circleId}, new CircleMapper());
		
	}
	
	public List<Circle> getAllCircles()
	{
		return jdbcTemplate.query("SELECT * FROM circle", new CircleMapper());
	}
	final class CircleMapper implements RowMapper<Circle>
	{

		@Override
		public Circle mapRow(ResultSet rs, int rowNumber) throws SQLException {
			// TODO Auto-generated method stub
			Circle circle = new Circle();
			circle.setId(rs.getInt("id"));
			circle.setName(rs.getString("name"));
			return circle;
		}
		
	}
	
	public void insertCircle(Circle circle)
	{
		jdbcTemplate.update("INSERT INTO circle VALUES (?,?)",new Object[] {circle.getId(), circle.getName()});
	}
	
	public void insertCircleNamedParameters(Circle circle)
	{
		System.out.println("Result from Named Params");
		
		String sql = "INSERT INTO circle VALUES (:id , :name)";
		SqlParameterSource namedParams = new MapSqlParameterSource("id",circle.getId()).addValue("name", circle.getName());
		namedJdbcTemplate.update(sql, namedParams);
	}
}
