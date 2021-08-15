package webtienganh.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import webtienganh.entity.User;
import webtienganh.repository.UserRepository;
import webtienganh.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void updateToken(String username, String token) {
		
		User user =  userRepository.findByUsername(username)
				.orElseThrow(() -> new UsernameNotFoundException("Tài khoản không tồn tại"));
		
		user.setToken(token);
		
		userRepository.save(user);
	}
//	
//	@Override
//	public void processOAuthPostLogin(CustomOAuth2UserService customOAuth2User) {
//		
//		String name = customOAuth2User.get;
//		String email = customOAuth2User.getEmail();
//		Optional<User> userOptional = userRepository.findByUsername(name);
//		
//		if (!userOptional.isPresent()) {
//			
//			User newUser = new User();
//			newUser.setName(name);
//			newUser.setUsername(email);
//			
//			
//			userRepository.save(newUser);
//		}
//		
//	}
}
