package kr.ac.sungkyul.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.sungkyul.mysite.dao.BBSDao;
import kr.ac.sungkyul.mysite.vo.BoardVo;

@Service
public class BBSService {
	@Autowired
	private BBSDao bbsDao;
	
	public void insert(BoardVo boardVo){
		bbsDao.insert(boardVo);
	}
	
	public List<BoardVo> list(){
		List<BoardVo> list = bbsDao.list();
		return list;
	}
	
	public BoardVo selectBoard(BoardVo vo){
		return bbsDao.selectBoard(vo);
	}
	
	public void deleteBoard(BoardVo vo){
		bbsDao.deleteBoard(vo);
	}
	
	public void updateBoard(BoardVo vo){
		bbsDao.updateBoard(vo);
	}
}
