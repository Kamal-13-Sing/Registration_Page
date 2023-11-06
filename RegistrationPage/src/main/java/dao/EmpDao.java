package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Employee;

public class EmpDao {
	
	private SessionFactory sessionFactory;

	public EmpDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	public boolean saveEmp(Employee e) {
		
		boolean status = false;
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		
		int i = (Integer)session.save(e);
		if(i > 0) {
			status = true;
		}
		
		tr.commit();
		session.close();
		return status;
	}

}
