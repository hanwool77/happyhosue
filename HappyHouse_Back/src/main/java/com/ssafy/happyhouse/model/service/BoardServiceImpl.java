package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.BoardDto;
import com.ssafy.happyhouse.model.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardDto> selectBoard() throws SQLException {
		return boardMapper.selectBoard();
	}

	@Override
	public BoardDto detailBoard(int boardId) {
		return boardMapper.selectBoardByNo(boardId);
	}

	@Override
	public boolean writeBoard(BoardDto board) throws SQLException {
		return boardMapper.insertBoard(board) == 1;
	}

	@Override
	public boolean updateBoard(BoardDto board) throws SQLException {
		return boardMapper.updateBoard(board) == 1;
	}

	@Override
	public boolean deleteBoard(int boardId) throws SQLException {
		return boardMapper.deleteBoard(boardId) == 1;
	}

}
