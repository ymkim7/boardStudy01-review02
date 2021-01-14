package kr.co.service;

import kr.co.vo.RecodeEduVO;
import kr.co.vo.RecodeVO;

public interface RecodeService {
	
	//등록
	public void insertRecode(RecodeVO recodeVO) throws Exception;
	
	//edu 등록
	public void insertRecodeEdu(RecodeEduVO recodeEduVO) throws Exception;

}
