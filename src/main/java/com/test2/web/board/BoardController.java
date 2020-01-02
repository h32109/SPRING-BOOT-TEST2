package com.test2.web.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test2.web.util.Printer;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class BoardController {
	@Autowired
	private BoardRepository boardRepository;
	@Autowired
	private Printer printer;
	
	@RequestMapping("/board")
	public String index() {
		Iterable<Board> all = boardRepository.findAll();
		StringBuilder sb = new StringBuilder();
		all.forEach(p -> sb.append(p.getTitle()+" "));
		return sb.toString();
	}
}
