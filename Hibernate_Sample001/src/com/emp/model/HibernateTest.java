package com.emp.model;

import java.util.Iterator;
import java.util.List;
import java.util.Collections;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;


import Util.HibernateUtil;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();

/*		//insert
		EmpVO empVO1 = new EmpVO();
		empVO1.setEname("§d¥Ã§Ó1");
		empVO1.setJob("MANAGER");
		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
		empVO1.setSal(new Double(50000));
		empVO1.setComm(new Double(500));
		empVO1.setDeptno(20);
		session.save(empVO1);
		tx.commit();*/
		
/*		//update
		EmpVO empVO2 = new EmpVO();
		empVO2.setEmpno(7020);
		empVO2.setEname("§d¥Ã§Ó2");
		empVO2.setJob("MANAGER");
		empVO2.setHiredate(java.sql.Date.valueOf("2005-01-01"));
		empVO2.setSal(new Double(50000));
		empVO2.setComm(new Double(500));
		empVO2.setDeptno(20);
		session.saveOrUpdate(empVO2);
		tx.commit();*/
		
		
/*		//delete
		EmpVO empVO3 = (EmpVO)session.get(EmpVO.class, 7019);
		session.delete(empVO3);
		tx.commit();*/
		
		
/*		//query one		
		EmpVO empVO = (EmpVO) session.get(EmpVO.class, 7003);
		System.out.println(empVO.getEname());
		session.close();*/
		

		
		//query all and sort reverse
		Criteria criteriaR = session.createCriteria(EmpVO.class);
		List<EmpVO> employeesR = criteriaR.list();
		
		employeesR.sort((o1, o2) -> o1.getEmpno().compareTo(o2.getEmpno()));
		//reverse
		Collections.reverse(employeesR);
		employeesR.forEach(s -> System.out.println(s.getEmpno()));
		
		tx.commit();
	}

}
