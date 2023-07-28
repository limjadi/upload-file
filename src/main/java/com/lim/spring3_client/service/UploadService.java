package com.lim.spring3_client.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author rudy.limjadi
 * @since 7/28/2023
 *
 */
public interface UploadService {
	
	@Async
	public abstract void uploadUsers(MultipartFile file);
}
