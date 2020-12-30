package kr.co.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.vo.BoardVO;
import kr.co.vo.Criteria;
import kr.co.vo.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sql;

	@Override
	public void write(BoardVO boardVO) throws Exception {
		sql.insert("board.write", boardVO);

	}

	@Override
	public List<BoardVO> list(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("board.list", scri);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("board.read", bno);
	}

	@Override
	public void update(BoardVO boardVO) throws Exception {
		sql.update("board.update", boardVO);
		
	}

	@Override
	public void delete(int bno) throws Exception {
		sql.delete("board.delete", bno);
		
	}

	@Override
	public int listCount(SearchCriteria scri) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("board.listCount", scri);
	}

	@Override
	public void insertFile(Map<String, Object> map) throws Exception {
		sql.insert("board.insertFile", map);
		
	}

	@Override
	public List<Map<String, Object>> selectFileList(int bno) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectList("board.selectFileList", bno);
	}

	@Override
	public Map<String, Object> selectFileInfo(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sql.selectOne("board.selectFileInfo", map);
	}

	@Override
	public void updateFile(Map<String, Object> map) throws Exception {
		sql.update("board.updateFile", map);
		
	}

	@Override
	public void boardHit(int bno) throws Exception {
		sql.update("board.boardHit", bno);
		
	}

}
