package dao;

import java.util.List;
import java.util.Map;

public interface MovieDAO {
	public List<Map<String,String>> movieList();	
	public int insertMovie(Map<String,String> movie);
}
