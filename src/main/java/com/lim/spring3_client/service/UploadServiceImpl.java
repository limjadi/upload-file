package com.lim.spring3_client.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.lim.spring3_client.entity.UploadFile;
import com.lim.spring3_client.entity.User;
import com.lim.spring3_client.entity.UserUpload;
import com.lim.spring3_client.repository.UploadFileRepository;
import com.lim.spring3_client.repository.UserRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 * 
 * @author rudy.limjadi
 * @since 7/28/2023
 *
 */
@Service
public class UploadServiceImpl implements UploadService {

	private static final Logger log = LoggerFactory.getLogger(UploadServiceImpl.class);

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UploadFileRepository uploadFileRepo;

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Async
	public void uploadUsers(MultipartFile file) {
		log.info("STARTING TO UPLOAD USER DATA FROM CSV FILE...");
		try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

			CsvToBean<UserUpload> csvToBean = new CsvToBeanBuilder(reader).withType(UserUpload.class)
					.withIgnoreLeadingWhiteSpace(true).build();

			List<UserUpload> userUploads = csvToBean.parse();

			List<User> users = new ArrayList<User>();
			for (UserUpload userUpload : userUploads) {
				users.add(createUser(userUpload));
			}
			userRepo.saveAll(users);
			log.info("SAVING TO M_USER DONE !");

			UploadFile uploadFile = new UploadFile();
			uploadFile.setFileName(file.getName());
//			uploadFile.setFileBlob(file.getBytes());
			uploadFileRepo.save(uploadFile);
			log.info("SAVING TO T_UPLOAD_FILE DONE !");
		} catch (Exception ex) {
			ex.printStackTrace();
			log.info("An error occurred while processing the CSV file.");
		}
		log.info("UPLOAD PROCESS FINISH !!!");
	}

	private User createUser(UserUpload userUpload) {
		return new User(userUpload.getName(), userUpload.getEmail(), userUpload.getCountryCode(), userUpload.getAge());
	}

}
