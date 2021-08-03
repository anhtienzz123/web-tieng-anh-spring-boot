package webtienganh.service;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {

	String uploadImage(MultipartFile image);
	void deleteImage(String publicId);
}
