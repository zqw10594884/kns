package com.zqw.util;

import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class DBUtil {

	public static void insert(Object obj) {
		Session session = null;
		try {
			session = HibUtil.getSession();
			Transaction transaction = session.beginTransaction();
			session.save(obj);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static Object getClassLst(String sql, String name) {

		Session session = null;
		Object obj = null;
		try {
			session = HibUtil.getSession();
			Query q1 = session.createQuery(sql);
			if (name.length() > 1) {
				q1.setString("name", name);
			}
			obj = q1.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}

	public static Object get(String sql, String name0, String name1) {

		Session session = null;
		Object obj = null;
		try {
			session = HibUtil.getSession();
			Query q1 = session.createQuery(sql);
			if (name0.length() > 1) {
				q1.setString("name0", name0);
			}
			if (name1.length() > 1) {
				q1.setString("name1", name1);
			}
			obj = q1.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}

	public static Object getClassLst(String sql, String name0, Date name1, Date name2) {

		Session session = null;
		Object obj = null;
		try {
			session = HibUtil.getSession();
			Query q1 = session.createQuery(sql);
			if (name0.length() > 1) {
				q1.setString("name0", name0);
			}
			if (name1 != null) {
				q1.setDate("name1", name1);
			}
			if (name2 != null) {
				q1.setDate("name2", name2);
			}
			obj = q1.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}

	public static Object getClassLst(String sql, int name0) {

		Session session = null;
		Object obj = null;
		try {
			session = HibUtil.getSession();
			Query q1 = session.createQuery(sql);
			if (name0 != -1) {
				q1.setInteger("name0", name0);
			}
			obj = q1.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}

	/***
	 * 
	 * 
	 * @param arg0
	 * @param name0
	 * @param nameArg0
	 * @param par
	 *            eq是等于，gt是大于，lt是小于,or是或
	 * @return
	 */
	public static Object getClass(Class arg0, String name0, String nameArg0, String par) {
		Session session = null;
		Object obj = null;
		try {
			session = HibUtil.getSession();
			Criteria c = session.createCriteria(arg0);
			if ("eq".endsWith(par)) {
				c.add(Restrictions.eq(name0, nameArg0));
			} else if ("gt".endsWith(par)) {
				c.add(Restrictions.gt(name0, Integer.parseInt(nameArg0)));
			} else if ("lt".endsWith(par)) {
				c.add(Restrictions.lt(name0, Integer.parseInt(nameArg0)));
			}
			obj = c.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}

	/**
	 * 
	 * @param arg0
	 * @param par
	 *            eq是等于，gt是大于，lt是小于,or是或
	 * @param nameArg0
	 * @return
	 */
	public static Object getLstClass(Class arg0, String par, String... nameArg0) {
		Session session = null;
		Object obj = null;
		try {
			session = HibUtil.getSession();
			Criteria c = session.createCriteria(arg0);
			for (int i = 0; i < nameArg0.length; i += 3) {
				if ("eq".endsWith(par)) {
					if (nameArg0[i + 2].endsWith("int")) {
						c.add(Restrictions.eq(nameArg0[i], Integer.parseInt(nameArg0[i + 1])));
					}else{
						c.add(Restrictions.eq(nameArg0[i], nameArg0[i + 1]));
					}
				} else if ("gt".endsWith(par)) {
					c.add(Restrictions.gt(nameArg0[i], Integer.parseInt(nameArg0[i + 1])));
				} else if ("lt".endsWith(par)) {
					c.add(Restrictions.lt(nameArg0[i], Integer.parseInt(nameArg0[i + 1])));
				}
			}
			obj = c.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return obj;
	}

	public static void update(String sql, String name0, int name1) {

		Session session = null;
		Transaction tx = null;
		try {
			session = HibUtil.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(sql);

			if (name0.length() > 0) {
				query.setString("name0", name0);
			}
			if (name1 > -1) {
				query.setInteger("name1", name1);
			}
			query.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void update(Object obj) {
		Session session = HibUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void del(Object obj) {
		Session session = HibUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public static void updateField(String hgl, String newField, String oldField) {
		Session session = HibUtil.getSession();
		Query q = session.createQuery(hgl);
		q.setParameter(0, newField);
		q.setParameter(1, oldField);
		q.executeUpdate();
	}

	public static void refresh() {
		HibUtil.creayFactory();
	}

	public static void delBySql(String hqlCurtainShopGoods_From_Name) {
		// TODO Auto-generated method stub
		Session session = HibUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			SQLQuery q = session.createSQLQuery(hqlCurtainShopGoods_From_Name);
			q.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

}
