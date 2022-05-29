package com.managementsystem.web;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.managementsystem.dao.EmployeeDao;
import com.managementsystem.model.Employee;
import com.managementsystem.model.Team;

/**
 * Servlet implementation class EmployeeServlet
 */
// @WebServlet("/Employee")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.print("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");

		HttpSession session = request.getSession(false);
		Employee employee = (Employee) session.getAttribute("currentEmployee");
		String action = request.getParameter("action");
		String id = request.getParameter("id");

		try {
			switch (action) {
			case "all":
				listAllEmployee(request, response);
				break;
			case "allDeveloper":
				listAllDeveloper(request, response);
				break;
			case "developerTeam":
				if (id != null && id != "")
					listDeveloperTeam(request, response, Integer.valueOf(id), employee.getEmployeeRule());
				else
					listDeveloperTeam(request, response, employee.getEmployeeID(), employee.getEmployeeRule());
				break;
			case "team":
				listTeam(request, response);
				break;
			case "new":
				showNewEmployeeForm(request, response, Integer.valueOf(id));
				break;
			case "newTeam":
				showNewTeamForm(request, response);
				break;
			case "insert":
				insertDeveloper(request, response, employee.getEmployeeRule());
				break;
			case "insertTeam":
				insertTeam(request, response, employee.getEmployeeRule());
				break;
			case "delete":
				delete(request, response, Integer.valueOf(id));
				break;
			case "logout":
				logout(request, response);
				break;
			// case "teamLeader":
			// listTask(request, response,employee.getEmployeeID());
			// break;
			}

		} catch (Exception ex) {
			throw new ServletException(ex);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void listAllEmployee(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> listEmployee = EmployeeDao.AllEmployee();
		request.setAttribute("listEmployee", listEmployee);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee/allEmployee.jsp");
		dispatcher.forward(request, response);
	}

	private void listAllDeveloper(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> listDeveloper = EmployeeDao.AllDevloper();
		request.setAttribute("listDeveloper", listDeveloper);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee/allDeveloper.jsp");
		dispatcher.forward(request, response);
	}

	private void listDeveloperTeam(HttpServletRequest request, HttpServletResponse response, int employeeID,
			String employeeRule) throws ServletException, IOException {
		System.out.println(employeeID);
		List<Employee> listDeveloperTeam = EmployeeDao.TeamDevloper(employeeID);
		request.setAttribute("listDeveloperTeam", listDeveloperTeam);
		request.setAttribute("employeeRule", employeeRule);
		request.setAttribute("id", employeeID);
		request.setAttribute("teamName", request.getParameter("teamName"));

		RequestDispatcher dispatcher = request.getRequestDispatcher("employee/developer.jsp");
		dispatcher.forward(request, response);
	}

	private void listTeam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Team> listTeam = EmployeeDao.Team();
		request.setAttribute("listTeam", listTeam);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee/team.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewEmployeeForm(HttpServletRequest request, HttpServletResponse response, int id)
			throws ServletException, IOException {
		request.setAttribute("id", id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee/newDeveloper.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewTeamForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("employee/newTeam.jsp");
		dispatcher.forward(request, response);
	}

	private void insertDeveloper(HttpServletRequest request, HttpServletResponse response, String employeeRule)
			throws ServletException, IOException {
		Random random = new Random();
		int randomNum = random.nextInt(50000000);
		String password = Integer.toString(random.nextInt(50000000));
		int phone = Integer.valueOf(request.getParameter("phone"));
		int teamID = Integer.valueOf(request.getParameter("id"));
		Employee employee = new Employee(request.getParameter("firstName"), request.getParameter("lastName"), phone,
				request.getParameter("address"), randomNum, "Developer", request.getParameter("email"), password);

		EmployeeDao.addEmployee(employee);

		EmployeeDao.addEmployeeTeam(teamID, randomNum);

		listDeveloperTeam(request, response, teamID, employeeRule);
	}

	private void insertTeam(HttpServletRequest request, HttpServletResponse response, String employeeRule)
			throws ServletException, IOException {
		Random random = new Random();
		int randomNum = random.nextInt(50000000);
		String password = Integer.toString(random.nextInt(50000000));
		int phone = Integer.valueOf(request.getParameter("phone"));
		Employee employee = new Employee(request.getParameter("firstName"), request.getParameter("lastName"), phone,
				request.getParameter("address"), randomNum, "TeamLeader", request.getParameter("email"), password);

		EmployeeDao.addEmployee(employee);

		EmployeeDao.addTeam(randomNum, request.getParameter("teamName"));

		listTeam(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response, int employeeID)
			throws ServletException, IOException {
		EmployeeDao.deleteEmplyee(employeeID);
		listAllEmployee(request, response);
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		session.invalidate();
		response.sendRedirect("home.jsp");
	}

}
