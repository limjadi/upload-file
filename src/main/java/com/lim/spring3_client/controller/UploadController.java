package com.lim.spring3_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lim.spring3_client.entity.ResponseMessage;
import com.lim.spring3_client.service.UploadService;

/**
 * 
 * @author rudy.limjadi
 * @since 7/28/2023
 *
 */
@RestController
public class UploadController {

	@Autowired
	private UploadService uploadService;

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> upload(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			uploadService.uploadUsers(file);

			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
}
