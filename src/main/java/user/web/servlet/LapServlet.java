package user.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.LapDao;
import user.dao.RaceDao;
import user.dao.RegisterDriver;
import user.dao.UserDao;
import user.domain.Driver;
import user.domain.Lap;
import user.domain.Race;
import user.domain.User;
import user.service.UserException;
import user.service.UserService;

/**
 * Servlet implementation class UserServlet
 */

public class LapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String[]> paramMap = request.getParameterMap();
		
		Lap form = new Lap();
		List<String> info = new ArrayList<String>();
		
		for(String name : paramMap.keySet()) {
			
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}
		form.setName(info.get(1));
		form.setTime(info.get(2));
		form.setLocation(info.get(3));
		
		LapDao rd = new LapDao();
		rd.Register(form);
		request.getRequestDispatcher("/jsps/main.jsp").forward(request, response);
	}

}
