/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.IDao;
import entities.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author hicham
 */
public class UserService implements IDao<User> {

	@Override
	public boolean create(User o) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.save(o);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return false;
	}

	@Override
	public boolean update(User o) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.update(o);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return false;
	}

	@Override
	public boolean delete(User o) {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			session.delete(o);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return false;
	}

	@Override
	public User findById(int id) {
		Session session = null;
		Transaction tx = null;
		User zone = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			zone = (User) session.get(User.class, id);
			tx.commit();
			return zone;
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public List<User> findAll() {
		Session session = null;
		Transaction tx = null;
		User zone = null;
		List<User> zones = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			zones = session.createQuery("from User").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return zones;

	}

	public User getByEmail(String email) {
		User c = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		c = (User) session.createSQLQuery("select id,login,password,nom,prenom,DTYPE,email,telephone from user where email = ?").addEntity(User.class).setParameter(0, email).uniqueResult();
		session.getTransaction().commit();
		return c;
	}

}
