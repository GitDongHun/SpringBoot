package com.food.exp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.exp.dao.RstDAO;
import com.food.exp.dao.UploadDAO;
import com.food.exp.dto.FileDTO;

@Service
public class UploadServiceImpl implements UploadService{

	@Autowired
    UploadDAO dao;

	@Override
	public int insert(FileDTO dto) {
		return dao.insert(dto);
	}

	@Override
	public int delete(FileDTO dto) {
		return dao.delete(dto);

	}

	@Override
	public List<FileDTO> getFiles(int rev_no) {
		return dao.getFiles(rev_no);
	}

	@Override
	public int currentRno() {
		return dao.currentRno();
	}
}
