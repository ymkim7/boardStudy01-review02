package kr.co.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	@Autowired
	private SqlSession sql;

	@Override
	public void register(MemberVO memberVO) throws Exception {
		sql.insert("member.register", memberVO);

	}

	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("member.login", memberVO);
	}

	@Override
	public void memberUpdate(MemberVO memberVO) throws Exception {
		sql.update("member.memberUpdate", memberVO);
		
	}

	@Override
	public void memberDelete(MemberVO memberVO) throws Exception {
		sql.delete("member.memberDelete", memberVO);
		
	}

	@Override
	public int passChk(MemberVO memberVO) throws Exception {
		
		int result = sql.selectOne("member.passChk", memberVO);
		
		return result;
	}

	@Override
	public int idChk(MemberVO memberVO) throws Exception {

		int result = sql.selectOne("member.idChk", memberVO);
		
		return result;
	}

}
