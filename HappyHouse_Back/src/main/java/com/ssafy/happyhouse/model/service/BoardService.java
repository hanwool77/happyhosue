package com.ssafy.happyhouse.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.model.BoardDto;



public interface BoardService {
	public List<BoardDto> selectBoard() throws SQLException;
	public BoardDto detailBoard(int boardId);
	public boolean writeBoard(BoardDto board) throws SQLException;
	public boolean updateBoard(BoardDto board) throws SQLException;
	public boolean deleteBoard(int boardId) throws SQLException;
}
