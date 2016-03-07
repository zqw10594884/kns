package com.zqw.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibUtil {
	private static SessionFactory factory;

	private HibUtil() {
	}

	static {
		creayFactory();
	}

	public static void creayFactory() {
		factory = null;
		Configuration configuration = new Configuration();
		configuration.configure();
		factory = configuration.buildSessionFactory();
	}
	
	public static SessionFactory getFactory() {
		return factory;
	}

	public static Session getSession() {
		return factory.openSession();
	}
}
