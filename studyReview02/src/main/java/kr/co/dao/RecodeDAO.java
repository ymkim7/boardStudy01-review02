package kr.co.dao;

import kr.co.vo.BoardVO;
import kr.co.vo.RecodeEduVO;
import kr.co.vo.RecodeVO;

public interface RecodeDAO {
	
	//메인 테이블 등록
	public void insertRecode(RecodeVO recodeVO) throws Exception;
	
	//edu 등록
	public void insertRecodeEdu(RecodeEduVO recodeEduVO) throws Exception;

}
