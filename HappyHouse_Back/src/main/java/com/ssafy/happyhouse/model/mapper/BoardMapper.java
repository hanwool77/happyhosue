package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.ssafy.happyhouse.model.BoardDto;


@Mapper
public interface BoardMapper {
	public List<BoardDto> selectBoard() throws SQLException;
	public BoardDto selectBoardByNo(int boardId);
	public int insertBoard(BoardDto board) throws SQLException;
	public int updateBoard(BoardDto board) throws SQLException;
	public int deleteBoard(int boardId) throws SQLException;
}
