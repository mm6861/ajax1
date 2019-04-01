package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MovieService;
import service.impl.MovieServletImpl;


public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieService ms = new MovieServletImpl();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		if(idx==0) {
			throw new ServletException("원하는 서비스가 부정확 합니다.");
			// 여기까지 들어왔다는 거는 사용자의 입력오류이기에 알려줘야 한다!! 
		}else {
			String cmd = uri.substring(idx+1);
			if("list".equals(cmd)) {
				request.setAttribute("list", ms.movieList());
				RequestDispatcher rd = request.getRequestDispatcher("/views/movie/list");
				rd.forward(request, response);
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		if(idx==0) {
			throw new ServletException("원하는 서비스가 부정확 합니다.");
		}else {
			String cmd = uri.substring(idx+1);
			if("insert".equals(cmd)) {
				HttpSession hs = request.getSession();
				if(hs.getAttribute("user")==null) {
					request.setAttribute("msg", "로그인하세요");
					request.setAttribute("url", "/");
					RequestDispatcher rd = request.getRequestDispatcher("/views/msg/result");
					rd.forward(request, response);
					return;
				}
				
				Map<String,String> movie = new HashMap<>();
				movie.put("mi_name", request.getParameter("mi_name"));
				movie.put("mi_year", request.getParameter("mi_year"));
				movie.put("mi_national", request.getParameter("mi_national"));
				movie.put("mi_vendor", request.getParameter("mi_vendor"));
				movie.put("mi_director", request.getParameter("mi_director"));
				request.setAttribute("msg", "영화등록실패!");
				if(ms.insertMovie(movie)==1) {
					request.setAttribute("msg", "영화등록성공!");
				}
				request.setAttribute("url", "/movie/list");
				RequestDispatcher rd = request.getRequestDispatcher("/views/msg/result");
				rd.forward(request, response);
			}
		}
	}

}
