package com.ssafy.happyhouse.controller;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.service.BoardService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private BoardService boardService;

	@GetMapping
	public ResponseEntity<List<BoardDto>> selectBoard() throws SQLException {
		return new ResponseEntity<List<BoardDto>>(boardService.selectBoard(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<String> writeBoard(@RequestBody BoardDto board) throws Exception {
		System.out.println(board);
		if (boardService.writeBoard(board)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);

	}

	@GetMapping("detail/{boardId}")
	public ResponseEntity<BoardDto> detailBoard(@PathVariable int boardId) {
		logger.debug("detailBoard - 호출");
		return new ResponseEntity<BoardDto>(boardService.detailBoard(boardId), HttpStatus.OK);
	}

	@PutMapping("{boardId}")
	public ResponseEntity<String> updateBoard(@RequestBody BoardDto board) throws SQLException {

		if (boardService.updateBoard(board)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

	@DeleteMapping("{boardId}")
	public ResponseEntity<String> deleteBoard(@PathVariable int boardId) throws SQLException {
		logger.debug("deleteBoard - 호출");
		if (boardService.deleteBoard(boardId)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}
