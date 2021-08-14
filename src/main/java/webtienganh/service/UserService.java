package webtienganh.service;

public interface UserService {

	void updateToken(String username, String token);
	
	public void processOAuthPostLogin(String username);
}
