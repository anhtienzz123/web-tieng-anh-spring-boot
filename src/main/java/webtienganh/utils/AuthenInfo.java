package webtienganh.utils;

import org.springframework.security.core.context.SecurityContextHolder;

public class AuthenInfo {

	public static String getUsername() {

		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
}
