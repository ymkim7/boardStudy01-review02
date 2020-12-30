package kr.co.service;

import java.util.List;

import kr.co.vo.ReplyVO;

public interface ReplyService {
	
	//댓글조회
	public List<ReplyVO> readReply(int bno) throws Exception;
	
	//댓글등록
	public void writeReply(ReplyVO replyVO) throws Exception;
	
	//댓글수정
	public void updateReply(ReplyVO replyVO) throws Exception;
	
	//댓글삭제
	public void deleteReply(ReplyVO replyVO) throws Exception;
	
	//선택 댓글조회
	public ReplyVO selectReply(int rno) throws Exception;

}
