package kr.ac.sungkyul.mysite.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.ac.sungkyul.mysite.vo.BoardVo;

@Repository
public class BBSDao {
	@Autowired
	private SqlSession sqlSession;
	
	public void insert(BoardVo boardVo){
		sqlSession.insert("bbs.insert", boardVo);
	}
	
	public List<BoardVo> list(){
		List<BoardVo> list = sqlSession.selectList("bbs.list");
		return list;
	}
	
	public BoardVo selectBoard(BoardVo boardVo){
		return sqlSession.selectOne("bbs.selectBoard", boardVo);
	}
	
	public void deleteBoard(BoardVo vo){
		sqlSession.delete("bbs.deleteBoard", vo);
	}
	
	public void updateBoard(BoardVo vo){
		sqlSession.update("bbs.updateBoard", vo);
	}
}
