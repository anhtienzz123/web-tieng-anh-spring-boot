package webtienganh.controller.admin;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/blogs")
@CrossOrigin
public class BlogAdminController {

	@GetMapping()
	public void getList() {
		System.out.println("blogs");
	}

}
