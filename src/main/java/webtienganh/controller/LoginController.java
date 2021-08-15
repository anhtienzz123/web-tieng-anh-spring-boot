package webtienganh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import webtienganh.config.security.JwtTokenProvider;
import webtienganh.dto.LoginRequestDTO;
import webtienganh.dto.LoginResponseDTO;
import webtienganh.entity.User;
import webtienganh.repository.UserRepository;
import webtienganh.service.UserService;

@RestController
@CrossOrigin
public class LoginController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenProvider tokenProvider;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/login")
	public LoginResponseDTO authenticateUser(@RequestBody LoginRequestDTO loginRequest) {

		String username = loginRequest.getUsername();
		Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = tokenProvider.generateToken(authentication.getName());
		userService.updateToken(username, jwt);
		return new LoginResponseDTO(loginRequest.getUsername(), jwt);

	}

	@GetMapping("/create-account")
	public void addAccount() {

		String token = tokenProvider.generateToken("admin");
		User adminUser = new User("TK Admin", "admin", passwordEncoder.encode("admin"), token, null);

		String token1 = tokenProvider.generateToken("user");
		User user = new User("TK User", "user", passwordEncoder.encode("user"), token1, null);

		userRepository.save(adminUser);
		userRepository.save(user);

	}
}
