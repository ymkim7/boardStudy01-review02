package kr.co.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.vo.RecodeEduVO;
import kr.co.vo.RecodeVO;

@Repository
public class RecodeDAOImpl implements RecodeDAO {
	
	@Autowired
	private SqlSession sql;

	@Override
	public void insertRecode(RecodeVO recodeVO) throws Exception {
		sql.insert("recode.insertRecode", recodeVO);

	}

	@Override
	public void insertRecodeEdu(RecodeEduVO recodeEduVO) throws Exception {
		sql.insert("recode.insertRecodeEdu", recodeEduVO);
		
	}

}
