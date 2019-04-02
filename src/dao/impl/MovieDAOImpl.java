package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.MovieDAO;
import db.DBCon;

public class MovieDAOImpl implements MovieDAO {
	private String selecteMovieList = "select mi_num,mi_name,mi_year,mi_national,mi_vendor,mi_director from movie_info";
	private String insertMovie = "insert into movie_info(mi_num,mi_name,mi_year,mi_national,mi_vendor,mi_director)"
			+ " values(seq_movie_num.nextval,?,?,?,?,?)";
	private String selectMovieByMiNum = "select * from movie_info where mi_num=?";
	private String deleteMovie = "delete from movie_info where mi_num=?";
	@Override
	public List<Map<String, String>> movieList() {
		List<Map<String, String>> movieList = new ArrayList<>();
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(selecteMovieList);
			ResultSet rs = ps.executeQuery();
			while(rs.next() ) {
				Map<String,String> m = new HashMap<>();
				m.put("mi_num", rs.getString("mi_num"));
				m.put("mi_name", rs.getString("mi_name"));
				m.put("mi_year", rs.getString("mi_year"));
				m.put("mi_national", rs.getString("mi_national"));
				m.put("mi_vendor", rs.getString("mi_vendor"));
				m.put("mi_director", rs.getString("mi_director"));
				movieList.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movieList;
	}

	@Override
	public int insertMovie(Map<String, String> movie) {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(insertMovie);
			ps.setString(1, movie.get("mi_name"));
			ps.setString(2, movie.get("mi_year"));
			ps.setString(3, movie.get("mi_national"));
			ps.setString(4, movie.get("mi_vendor"));
			ps.setString(5, movie.get("mi_director"));
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	@Override
	public Map<String, String> selectMovieByMiNum(int miNum) {
		
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(selectMovieByMiNum);
			ps.setInt(1, miNum);
			ResultSet rs = ps.executeQuery();
			while(rs.next() ) {
				Map<String,String> movie = new HashMap<>();
				movie.put("mi_num", rs.getString("mi_num"));
				movie.put("mi_name", rs.getString("mi_name"));
				movie.put("mi_year", rs.getString("mi_year"));
				movie.put("mi_national", rs.getString("mi_national"));
				movie.put("mi_vendor", rs.getString("mi_vendor"));
				movie.put("mi_director", rs.getString("mi_director"));
				return movie;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public int deleteMovie(int miNum) {
		PreparedStatement ps;
		try {
			ps = DBCon.getCon().prepareStatement(deleteMovie);
			ps.setInt(1, miNum);
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return 0;
	}
	public static void main(String[] args) {
		MovieDAO mdao = new MovieDAOImpl();
		System.out.println(mdao.movieList() );
		
		Map<String,String> movie = new HashMap<>();
		movie.put("mi_name", "메롱");
		movie.put("mi_year", "1920");
		movie.put("mi_national", "ko");
		movie.put("mi_vendor", "234");
		movie.put("mi_director", "음하하");
		System.out.println(mdao.insertMovie(movie));
	}



}
