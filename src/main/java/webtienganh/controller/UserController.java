package webtienganh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import webtienganh.dto.UserDTO;

@RestController
@RequestMapping("/users")
public class UserController {

	
	@GetMapping("")
	public List<UserDTO> getUsers(){
		
		List<UserDTO> result = new ArrayList<>();
			
		UserDTO userDTO = new UserDTO(1, "huynhanhtien");
		result.add(userDTO);
		
		return result;
	}
		
}
