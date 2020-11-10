package com.maersk.test.solution4;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

	@Autowired
	private JdbcTemplate template;

	final String INSERT_QUERY = "insert into movies (name, year, rating) values (?, ?, ?)";
	final String SELECT_BY_NAME_QUERY = "SELECT * from movies where name like ?";

	@PostConstruct
	public void createTable() {
		template.execute(
				"CREATE TABLE movies (id bigint auto_increment primary key, name VARCHAR(50), year int, rating int)");
	}

	public void createMovie(String name, int year, int rating) {
		template.update(INSERT_QUERY, name, year, rating);
	}

	public List<Movie> findMoviesByName(String likeName) {
		return template.query(SELECT_BY_NAME_QUERY, new MovieMapper(), likeName);
	}

	private static final class MovieMapper implements RowMapper<Movie> {
		public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
			Movie movie = new Movie();
			movie.setName(rs.getString("name"));
			movie.setYear(rs.getInt("year"));
			movie.setRating(rs.getInt("rating"));
			return movie;
		}
	}

}
