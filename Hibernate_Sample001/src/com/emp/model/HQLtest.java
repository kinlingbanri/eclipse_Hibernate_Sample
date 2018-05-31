package com.emp.model;

import java.util.Collections;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Util.HibernateUtil;

public class HQLtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
/*		//�i����
		Query query = session.createQuery("from EmpVO");
		query.setFirstResult(0);
		//query.setMaxResults(3);*/
		
		//�ʸˬd�߱���
		//Query query = session.createQuery("from EmpVO where ename like '%N%'");
		
		//�ʸˬd�߱���
		//Query query = session.createQuery("from EmpVO where empno=7010 and ename='WARD' order by empno");
		
/*		//�ѼƸj�w-�ϥ�?
		Query query = session.createQuery("from EmpVO where empno=? and ename=? order by empno");
		query.setParameter(0, 7014);
		query.setParameter(1, "ADAMS");*/

/*		//�ѼƸj�w-�Ϩ�W�Ѽ�(Named Parameter)
		Query query = session.createQuery("from EmpVO where empno=:empno and ename=:ename order by empno");
		query.setParameter("empno", 7024);
		query.setParameter("ename", "�d�ç�1");*/
		
		
		
		//�d�ߵ���
		Query query = session.createQuery("select count(*) as count from EmpVO");
		long count = (Long)query.list().get(0);
		System.out.println("**������Ʀ@" + count + "��");
		
		//�d�ߥ�����
		query = session.createQuery("select avg(sal) from EmpVO");
		Double countD = (Double)(query.list().get(0));
		System.out.println("**�����~����" + count + "��");
		
		//�h������
		query = session.createQuery("select distinct deptno from EmpVO order by deptno");
		List<Object> empVO = query.list();
		for(Object obj : empVO) {
			System.out.println("�����s��:" + obj);
		}
		
		query = session.createQuery("from EmpVO");
		List<EmpVO> list = query.list();	
		list.sort((o1, o2) -> o1.getEmpno().compareTo(o2.getEmpno()));
		//Collections.reverse(list);
		list.forEach(s -> {
			System.out.print(s.getEmpno() + ", ");
			System.out.println(s.getEname());
		} );
		
		tx.commit();
		
		
		
		
		
	}

}
