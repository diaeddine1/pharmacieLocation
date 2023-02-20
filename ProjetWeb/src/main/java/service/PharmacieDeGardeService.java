/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.IDao;

import entities.PharmacieDeGarde;
import util.HibernateUtil;

/**
 *
 * @author hicham
 */
public class PharmacieDeGardeService implements IDao<PharmacieDeGarde> {

	public boolean create(PharmacieDeGarde o) {
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
	public boolean update(PharmacieDeGarde o) {
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
	public boolean delete(PharmacieDeGarde o) {
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
	public PharmacieDeGarde findById(int id) {
		Session session = null;
		Transaction tx = null;
		PharmacieDeGarde garde = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			garde = (PharmacieDeGarde) session.get(PharmacieDeGarde.class, id);
			tx.commit();
			return garde;
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
	public List<PharmacieDeGarde> findAll() {
		Session session = null;
		Transaction tx = null;
		PharmacieDeGarde garde = null;
		List<PharmacieDeGarde> pharmaciedegardes = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tx = session.beginTransaction();
			pharmaciedegardes = session.createQuery("from PharmacieDeGarde").list();
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
		return pharmaciedegardes;
	}
}