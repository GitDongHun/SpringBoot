package com.food.exp.service;

import java.util.List;

import com.food.exp.dto.FileDTO;

public interface UploadService {

	public int insert(FileDTO dto);
	public int delete(FileDTO dto);
	public List<FileDTO> getFiles(int rev_no);
	public int currentRno();
	public List<FileDTO> getFilesRst(String rst_id);

}
