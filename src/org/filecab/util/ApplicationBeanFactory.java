package org.filecab.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class ApplicationBeanFactory {

	private static ApplicationContext context = null;
	
	static {
		setContext(new ClassPathXmlApplicationContext("applicationContext.xml"));
	}
	
	private ApplicationBeanFactory() {
	}
	
	public static Object getBean(Class<?> clazz) {
		return getContext().getBean(clazz.getSimpleName());
	}
	
	public static ApplicationContext getContext() {
		return context;
	}
	
	public static void setContext(ApplicationContext context) {
		ApplicationBeanFactory.context = context;
	}
	
}
