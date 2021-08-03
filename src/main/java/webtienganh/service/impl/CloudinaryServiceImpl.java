package webtienganh.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import webtienganh.service.CloudinaryService;
import webtienganh.utils.FileUtils;

@Service
@Transactional
public class CloudinaryServiceImpl implements CloudinaryService {

	@Autowired
	private Cloudinary cloudinaryConfig;

	public String uploadImage(MultipartFile image) {
		try {
			File uploadedFile = FileUtils.convertMultiPartToFile(image);
			Map<?, ?> uploadResult = cloudinaryConfig.uploader().upload(uploadedFile, ObjectUtils.emptyMap());

			String url = uploadResult.get("url").toString();
			
			return url;
		} catch (Exception e) {

			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteImage(String publicId) {
		try {

			cloudinaryConfig.uploader().destroy(publicId, ObjectUtils.emptyMap());

		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
