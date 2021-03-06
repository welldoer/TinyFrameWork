package net.blogjava.tiny4j.framework.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.blogjava.tiny4j.framework.helper.ClassHelper;

public final class BeanHelper {

	private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();
	
	static {
		Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
		for( Class<?> beanClass : beanClassSet ) {
			Object obj = ReflectionUtil.newInstance( beanClass );
			BEAN_MAP.put( beanClass, obj );
		}
	}
	
	public static Map<Class<?>, Object> getBeanMap() {
		return BEAN_MAP;
	}
	
	public static <T> T getBean( Class<T> cls ) {
		if( ! BEAN_MAP.containsKey( cls ) ) {
			throw new RuntimeException( "can not get bean by class: " + cls );
		}
		return (T) BEAN_MAP.get( cls );
	}

}
