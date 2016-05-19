package com.zqw.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.zqw.bean.SaleOrderGoods;
import com.zqw.ui.SaleMain;

public class ReflectionUtil {
	/**
	 * 
	 * @param fieldName
	 * @param opt
	 *            “get，is，set”
	 * @return
	 */
	public static String fieldConvertMethods(String fieldName, String opt) {
		String name = fieldName.substring(0, 1);
		return opt + fieldName.replaceFirst(name, name.toUpperCase());

	}

	public static void setField(Object class1, SaleMain class2) {
		Method methods1 = null;
		Method methods2 = null;
		ArrayList<String> f2Name = new ArrayList<String>();
		Class<? extends Object> c1 = class1.getClass();
		Class<? extends Object> c2 = class2.getClass();
		Field[] f1 = c1.getDeclaredFields();
		Field[] f2 = c2.getDeclaredFields();
		for (int i = 0; i < f2.length; i++) {
			f2Name.add(f2[i].getName());
		}
		try {
			for (int i = 0; i < f1.length; i++) {
				if (f2Name.contains(f1[i].getName())) {
					String methodName1 = fieldConvertMethods(f1[i].getName(), "get");
					methods1 = SaleOrderGoods.class.getMethod(methodName1);
					Object data = methods1.invoke(class1);
					Field ff2 = c2.getDeclaredField(f1[i].getName());
					Class<?> type = ff2.getType();
					String methodName2 = null;
					if (type == JComboBox.class) {
						methodName2 = "setSelectedItem";
						methods2 = JComboBox.class.getMethod(methodName2);
						methods2.invoke(class2, data.toString());
					} else if (type == JTextField.class){
						methodName2 = "setText";
						methods2 = ff2.getType().getMethod(methodName2,String.class);
						Object o =ff2.getType().newInstance();
						methods2.invoke(o, data.toString());
					}
				}
			}
		} catch (NoSuchMethodException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static int convertInt(String data) {
		return Integer.parseInt(data);
	}

	public static double convertDouble(String data) {
		return Double.parseDouble(data);
	}

	public static long convertLong(String data) {
		return Long.parseLong(data);
	}

	public static double convertFloat(String data) {
		return Float.parseFloat(data);
	}

	public static boolean convertBoolean(String data) {
		if ("true".equalsIgnoreCase(data)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * @param initialCapacity
	 *            the initial capacity of HashMap
	 * @param obj
	 * @return the obj of field and the field of value
	 */
	// public static Map<String, String> getFieldMap(Object obj,
	// int initialCapacity) {
	// Class<Overlay> cla = Overlay.class;
	// Field[] overlayFields = cla.getDeclaredFields();
	// Map<String, String> map = new HashMap<String, String>(initialCapacity);
	//
	// for (int i = 0; i < overlayFields.length; i++) {
	// Class<?> classField = overlayFields[i].getType();
	// String fieldName = overlayFields[i].getName();
	// String overlayMethodName = null;
	//
	// if (boolean.class == classField || String.class == classField
	// || int.class == classField || float.class == classField
	// || double.class == classField) {
	//
	// if (boolean.class == classField) {
	// overlayMethodName = fieldConvertMethods(fieldName, "is");
	// } else {
	// overlayMethodName = fieldConvertMethods(fieldName, "get");
	// }
	// Method methods;
	// try {
	// methods = cla.getMethod(overlayMethodName);
	// Object data = methods.invoke(obj);
	// if (null == data) {
	// data = "";
	// }
	// map.put(fieldName, data.toString());
	// } catch (NoSuchMethodException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (SecurityException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IllegalAccessException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (IllegalArgumentException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// } catch (InvocationTargetException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// }
	// return map;
	// }

}
