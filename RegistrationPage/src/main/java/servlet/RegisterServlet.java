package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.HibernateUtil;
import dao.EmpDao;
import entity.Employee;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String department = request.getParameter("department");
		String salary = request.getParameter("salary");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		//System.out.println("NAme: "+name);
		Employee emp = new Employee(name, department, salary, email, password);
		System.out.println(emp);
		
		EmpDao dao = new EmpDao(HibernateUtil.getSessionFactory());
		boolean status = dao.saveEmp(emp);
		
		
		
		if(status) {
			System.out.println("Register Sucess");
			out.println("register Sucess");
		}else {
			System.out.println("Register failed");
			out.println("register failed");
		}
	}

}
