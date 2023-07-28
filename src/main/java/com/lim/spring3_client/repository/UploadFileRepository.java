package com.lim.spring3_client.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lim.spring3_client.entity.UploadFile;

/**
 * 
 * @author rudy.limjadi
 * @since 7/28/2023
 *
 */
@Repository
public interface UploadFileRepository extends CrudRepository<UploadFile, Long> {

	List<UploadFile> findByFileName(String fileName);

	UploadFile findById(long id);

}
