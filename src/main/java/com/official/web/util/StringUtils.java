package com.official.web.util;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class StringUtils {
	public String toString(Object object) {// 重新tostring方法
		Class clazz = object.getClass();// 获得代表该类的class对象
		StringBuilder sb = new StringBuilder();// 创建容器保存字符串
		Package packageName = clazz.getPackage();// 获得该类的包
		sb.append("包名：" + packageName.getName() + "\t");// 输出类所在的包
		String className = clazz.getSimpleName();// 获得类的名称
		sb.append("类名" + className + "\n");
		sb.append("公共构造方法");
		// 获得所有代表构造方法的constructor数组
		Constructor[] constructors = clazz.getDeclaredConstructors();
		for (Constructor constructor : constructors) {
			String modifier = Modifier.toString(constructor.getModifiers());// 获得构造修饰符
			if (modifier.contains("public")) {// 查看修饰符是否含public
				sb.append(constructor.toGenericString() + "\n");
			}
		}
		sb.append("公共域：\n");
		Field[] fields = clazz.getDeclaredFields();// 获得该类的所有成员遍历
		for (Field field : fields) {
			String modifier = Modifier.toString(field.getModifiers());// 获得修饰符
			if (modifier.contains("public")) {
				sb.append(field.toGenericString() + "\n");
			}
		}
		sb.append("公共方法\n");
		Method[] methods = clazz.getDeclaredMethods();// 获得方法
		for (Method method : methods) {
			String modifier = Modifier.toString(method.getModifiers());
			if (modifier.contains("public")) {
				sb.append(method.toGenericString() + "\n");
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(new StringUtils().toString(new java.util.Date()));

	}
}
