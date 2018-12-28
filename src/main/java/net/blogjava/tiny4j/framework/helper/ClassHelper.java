package net.blogjava.tiny4j.framework.helper;

import java.util.HashSet;
import java.util.Set;

import net.blogjava.tiny4j.framework.annotation.Controller;
import net.blogjava.tiny4j.framework.annotation.Service;
import net.blogjava.tiny4j.framework.util.ClassUtil;

public final class ClassHelper {
	
	private static final Set<Class<?>> CLASS_SET;
	
	static {
		String basePackage = ConfigHelper.getAppBasePackage();
		CLASS_SET = ClassUtil.getClassSet( basePackage );
	}
	
	public static Set<Class<?>> getClassSet() {
		return CLASS_SET;
	}
	
	public static Set<Class<?>> getServiceClassSet() {
		Set<Class<?>> classSet = new HashSet<>();
		for( Class<?> cls : CLASS_SET ) {
			if( cls.isAnnotationPresent( Service.class ) ) {
				classSet.add( cls );
			}
		}
		return classSet;
	}
	
	public static Set<Class<?>> getControllerClassSet() {
		Set<Class<?>> classSet = new HashSet<>();
		for( Class<?> cls : CLASS_SET ) {
			if( cls.isAnnotationPresent( Controller.class ) ) {
				classSet.add( cls );
			}
		}
		return classSet;
	}
	
	public static Set<Class<?>> getBeanClassSet() {
		Set<Class<?>> beanClassSet = new HashSet<>();
		beanClassSet.addAll( getServiceClassSet() );
		beanClassSet.addAll( getControllerClassSet() );
		return beanClassSet;
	}
	
}
