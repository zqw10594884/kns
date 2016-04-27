package com.zqw.util;

import org.hibernate.Hibernate;
import org.hibernate.dialect.MySQL5Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;

public class MySQL5LocalDialect extends MySQL5Dialect {
	public MySQL5LocalDialect() {
		super();
		registerFunction("convert", new SQLFunctionTemplate(Hibernate.STRING, "convert(?1 using ?2)"));
	}
}