package ghtk.excel.model;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MyFile {
	private MultipartFile multipartFile;
	private String description;

}
