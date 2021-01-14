package kr.co.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dao.RecodeDAO;
import kr.co.vo.RecodeEduVO;
import kr.co.vo.RecodeVO;

@Service
public class RecodeServiceImpl implements RecodeService {
	
	@Autowired
	private RecodeDAO dao;

	@Override
	public void insertRecode(RecodeVO recodeVO) throws Exception {
		dao.insertRecode(recodeVO);

	}

	@Override
	public void insertRecodeEdu(RecodeEduVO recodeEduVO) throws Exception {
		dao.insertRecodeEdu(recodeEduVO);
		
	}

}
