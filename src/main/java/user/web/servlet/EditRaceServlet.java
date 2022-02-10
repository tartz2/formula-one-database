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

import user.dao.RaceDao;
import user.dao.RegisterDriver;
import user.dao.UserDao;
import user.domain.Driver;
import user.domain.Race;
import user.domain.User;
import user.service.UserException;
import user.service.UserService;

/**
 * Servlet implementation class UserServlet
 */

public class EditRaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public EditRaceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String,String[]> paramMap = request.getParameterMap();
		
		Race form = new Race();
		List<String> info = new ArrayList<String>();
		
		for(String name : paramMap.keySet()) {
			
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}
		form.setLocation(info.get(1));
		form.setDate(info.get(2));
		form.setOldTeam(info.get(3));
		form.setTeam(info.get(4));
		
		RaceDao rd = new RaceDao();
		rd.Edit(form);
		request.getRequestDispatcher("/jsps/main.jsp").forward(request, response);
		
	}

}
