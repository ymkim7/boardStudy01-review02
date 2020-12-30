package kr.co.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.dao.MemberDAO;
import kr.co.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO dao;

	@Override
	public void register(MemberVO memberVO) throws Exception {
		dao.register(memberVO);

	}

	@Override
	public MemberVO login(MemberVO memberVO) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(memberVO);
	}

	@Override
	public void memberUpdate(MemberVO memberVO) throws Exception {
		dao.memberUpdate(memberVO);
		
	}

	@Override
	public void memberDelete(MemberVO memberVO) throws Exception {
		dao.memberDelete(memberVO);
		
	}

	@Override
	public int passChk(MemberVO memberVO) throws Exception {
		
		int result = dao.passChk(memberVO);
		
		return result;
	}

	@Override
	public int idChk(MemberVO memberVO) throws Exception {

		int result = dao.idChk(memberVO);
		
		return result;
	}

}
