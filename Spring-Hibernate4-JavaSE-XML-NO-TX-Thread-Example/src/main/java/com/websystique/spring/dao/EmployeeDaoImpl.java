package com.websystique.spring.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.websystique.spring.model.Employee;

// @Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao implements EmployeeDao{

	public void saveEmployee(Employee employee) {
//		try {
//		System.out.println("++++++++++++++++++++++" + getSessionFactory().getCurrentSession());
//		} catch (RuntimeException e) {
//			System.out.println("+++++++++++++ddddd+++++++++");
//		
//			getSessionFactory().openSession();
//		}
//		
//		try {
//			System.out.println("++++++++++222++++++++++++" + getSessionFactory().getCurrentSession());
//			} catch (RuntimeException e) {
//				System.out.println("+++++++++++++ddddd+++222++++++");
//				getSessionFactory().openSession();
//			}
		
		 try{
			 getSession().beginTransaction();
			 persist(employee);
			 getSession().getTransaction().commit();

		      
		    }catch (RuntimeException e) {
		      try{
		    	  getSession().getTransaction().rollback();
		      }catch(RuntimeException ex){
		         ex.printStackTrace(); 
		      }   
		     //  throw e;
		    }
	}

	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Criteria criteria = getSession().createCriteria(Employee.class);
		return (List<Employee>) criteria.list();
	}

	public void deleteEmployeeBySsn(String ssn) {
		Query query = getSession().createSQLQuery("delete from Employee where ssn = :ssn");
		query.setString("ssn", ssn);
		query.executeUpdate();
	}

	
	public Employee findBySsn(String ssn){
		Criteria criteria = getSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("ssn",ssn));
		return (Employee) criteria.uniqueResult();
	}
	
	public void updateEmployee(Employee employee){
		getSession().update(employee);
	}
	
}
