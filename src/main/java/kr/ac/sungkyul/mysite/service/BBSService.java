package kr.ac.sungkyul.mysite.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.sungkyul.mysite.dao.BBSDao;
import kr.ac.sungkyul.mysite.vo.AttachFileVo;
import kr.ac.sungkyul.mysite.vo.BoardVo;

@Service
public class BBSService {
	@Autowired
	private BBSDao bbsDao;
	
	@Transactional
	public void insert(BoardVo boardVo, MultipartFile file) throws Exception {

		// 2. no --> 게시글 저장할 때
		Long no = bbsDao.insert(boardVo);
		
		// 1. fno --> 저장할 때
		
		// 3. orgName
		String orgName = file.getOriginalFilename();
		
		// 4. fileSize
		Long fileSize = file.getSize();
		
		// 5. saveName
		String saveName = UUID.randomUUID().toString() + "_" + orgName;
		
		// 6. path
		String path = "c:\\upload";
		
		AttachFileVo attachFileVo = new AttachFileVo();
		attachFileVo.setNo(no);
		attachFileVo.setPath(path);
		attachFileVo.setOrgName(orgName);
		attachFileVo.setSaveName(saveName);
		attachFileVo.setFileSize(fileSize);
		
		System.out.println(attachFileVo);
		
		bbsDao.insertAttachFile(attachFileVo);
		
		// 파일 저장
		File target = new File(path, saveName);
		FileCopyUtils.copy(file.getBytes(), target);
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
	
	public void insertAttachFile(AttachFileVo attachFileVo){
		bbsDao.insertAttachFile(attachFileVo);
	}
	
	public AttachFileVo selectAttachFileByNo(Long no){
		AttachFileVo vo = bbsDao.selectAttachFileByNo(no);
		return vo;
	}
	
	public AttachFileVo selectAttachFileByFno(Long fNo){
		AttachFileVo vo = bbsDao.selectAttachFileByFno(fNo);
		return vo;
	}
}
