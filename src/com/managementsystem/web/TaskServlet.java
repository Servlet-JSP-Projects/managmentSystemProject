package com.managementsystem.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import com.managementsystem.dao.EmployeeDao;
import com.managementsystem.dao.TaskDao;
import com.managementsystem.model.Employee;
import com.managementsystem.model.Task;

/**
 */
//@WebServlet("/Task")
public class TaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TaskServlet() {
        super();    // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession(false);  
        Employee employee =(Employee) session.getAttribute("currentEmployee"); 
        int employeeID =employee.getEmployeeID();
        String action = request.getParameter("action");
        String id;
		
		try{
        	switch (action) {
  			case "list":
  				id = request.getParameter("id");
  				if(id!=null)listTask(request, response,Integer.parseInt(id),"no");
  				else listTask(request, response,employeeID,"yes");
  				break;
  			case "new":
  				showNewForm(request, response);
  				break;
  			case "insert":
  				insertTask(request, response,employeeID);
  				break;
  			case "completed":
  				updateTask(request, response,employeeID,"Completed");
  				break;
  			case "uncompleted":
  				updateTask(request, response,employeeID,"In Progress");
  				break;
  			case "delete":
  				deleteTask(request, response,employeeID);
  				break;
  			case "deleteComp":
  				deleteCompTask(request, response,employeeID);
  				break;
  			}
        	
		} catch(Exception ex) {
			throw new ServletException(ex);
	    }
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);		
	}	


	private void listTask(HttpServletRequest request, HttpServletResponse response, int employeeID,String isMyTask)throws ServletException, IOException {
		List<Task> listTask = TaskDao.MyTask(employeeID);
	    System.out.println(listTask);
		request.setAttribute("listTask", listTask);
		request.setAttribute("isMyTask", isMyTask);
		request.setAttribute("employeeName",EmployeeDao.employeeName(employeeID));
		RequestDispatcher dispatcher = request.getRequestDispatcher("task/list.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {       
		RequestDispatcher dispatcher = request.getRequestDispatcher("task/new.jsp");
		dispatcher.forward(request, response);
	}
	
	private void insertTask(HttpServletRequest request, HttpServletResponse response,int employeeID)throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        if(id!=null && id!=""){
        	 TaskDao.insertTask(Integer.parseInt(id), name, description);
        	 listTask(request,response,Integer.valueOf(id),"no");
        }
        else {
        	TaskDao.insertTask(employeeID, name, description);
        	listTask(request,response,employeeID,"yes");
        }
        
	}
	
	private void updateTask(HttpServletRequest request, HttpServletResponse response,int employeeID,String text)throws ServletException, IOException {		
		int taskID=Integer.parseInt(request.getParameter("id"));
		TaskDao.editTask(taskID,employeeID,text);
		listTask(request,response,employeeID,"yes");
	}
    
	private void deleteTask(HttpServletRequest request, HttpServletResponse response,int employeeID)throws ServletException, IOException {		
		int taskID=Integer.parseInt(request.getParameter("id"));
		TaskDao.deleteTask(taskID);
		listTask(request,response,employeeID,"yes");
	}
	
    private void deleteCompTask(HttpServletRequest request, HttpServletResponse response,int employeeID)throws ServletException, IOException {		
		TaskDao.deleteCompTask();
		listTask(request,response,employeeID,"yes");
	}

}
