package net.blogjava.tiny4j.framework.helper;

import java.util.Properties;

import net.blogjava.tiny4j.framework.ConfigConstant;
import net.blogjava.tiny4j.framework.util.PropsUtil;

public final class ConfigHelper {
	
	private static final Properties CONFIG_PROPS = PropsUtil.loadProps( ConfigConstant.CONFIG_FILE );
	
	public static String getJdbcDriver() {
		return PropsUtil.getString( CONFIG_PROPS, ConfigConstant.JDBC_DRIVER );
	}

	public static String getJdbcUrl() {
		return PropsUtil.getString( CONFIG_PROPS, ConfigConstant.JDBC_URL );
	}

	public static String getAppBasePackage() {
		return PropsUtil.getString( CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE );
	}

	public static String getAppJspPath() {
		return PropsUtil.getString( CONFIG_PROPS, ConfigConstant.APP_JSP_PATH, "/WEB-INF/view/" );
	}

	public static String getAppAssetPath() {
		return PropsUtil.getString( CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH, "/asset/" );
	}

}
