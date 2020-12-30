package kr.co.service;

import kr.co.vo.MemberVO;

public interface MemberService {
	
	//게시글 등록
	public void register(MemberVO memberVO) throws Exception;
	
	//로그인
	public MemberVO login(MemberVO memberVO) throws Exception;
	
	//회원정보수정
	public void memberUpdate(MemberVO memberVO) throws Exception;
	
	//회원탈퇴
	public void memberDelete(MemberVO memberVO) throws Exception;
	
	//패스워드 체크
	public int passChk(MemberVO memberVO) throws Exception;
	
	//패스워드 체크
	public int idChk(MemberVO memberVO) throws Exception;

}
