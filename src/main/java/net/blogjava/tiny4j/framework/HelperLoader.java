package net.blogjava.tiny4j.framework;

import net.blogjava.tiny4j.framework.helper.ClassHelper;
import net.blogjava.tiny4j.framework.helper.ControllerHelper;
import net.blogjava.tiny4j.framework.util.BeanHelper;
import net.blogjava.tiny4j.framework.util.ClassUtil;
import net.blogjava.tiny4j.framework.util.IoCHelper;

public final class HelperLoader {
	
	public static void init() {
		Class<?>[] classList = {
				ClassHelper.class,
				BeanHelper.class,
				IoCHelper.class,
				ControllerHelper.class
		};
		for( Class<?> cls : classList ) {
			ClassUtil.loadClass( cls.getName(), true );
		}
	}

}
