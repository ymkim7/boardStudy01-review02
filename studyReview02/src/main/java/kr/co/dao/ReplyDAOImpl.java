package kr.co.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.vo.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {
	
	@Autowired
	private SqlSession sql;

	@Override
	public List<ReplyVO> readReply(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("reply.readReply", bno);
	}

	@Override
	public void writeReply(ReplyVO replyVO) throws Exception {
		sql.insert("reply.writeReply", replyVO);
		
	}

	@Override
	public void updateReply(ReplyVO replyVO) throws Exception {
		sql.update("reply.updateReply", replyVO);
		
	}

	@Override
	public void deleteReply(ReplyVO replyVO) throws Exception {
		sql.delete("reply.deleteReply", replyVO);
		
	}

	@Override
	public ReplyVO selectReply(int rno) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("reply.selectReply", rno);
	}

}
