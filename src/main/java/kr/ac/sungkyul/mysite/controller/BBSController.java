package kr.ac.sungkyul.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.ac.sungkyul.mysite.service.BBSService;
import kr.ac.sungkyul.mysite.vo.BoardVo;

@Controller
@RequestMapping("/bbs")
public class BBSController {
	@Autowired
	private BBSService bbsService;
	
	// 글 쓰기
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String write(){
		return "board/write";
	}
	
	// 글 등록
	@RequestMapping(value="register", method=RequestMethod.POST)
	public String register(BoardVo boardVo){
		bbsService.insert(boardVo);
		
		return "redirect:/bbs/list";
	}
	
	// 리스트
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String listBoard(Model model){
		List<BoardVo> list = bbsService.list();
		
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	// 글 보기
	@RequestMapping(value="view", method=RequestMethod.GET)
	public String boardView(Model model, BoardVo vo){
		vo = bbsService.selectBoard(vo);
		
		model.addAttribute("vo", vo);
		
		return "board/view";
	}
	
	// 글 삭제
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String boardDelete(BoardVo vo){
		bbsService.deleteBoard(vo);
		
		return "redirect:/bbs/list";
	}
	
	// 글 수정 폼
	@RequestMapping(value="modify", method=RequestMethod.GET)
	public String boardModify(Model model, BoardVo vo){
		vo = bbsService.selectBoard(vo);
		model.addAttribute("vo", vo);
		return "board/modify";
	}
	
	// 글 수정
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String boardUpdate(BoardVo vo){
		bbsService.updateBoard(vo);
		
		return "redirect:/bbs/view?no=" + vo.getNo();
	}
}
