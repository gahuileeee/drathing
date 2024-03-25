package com.drathing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.drathing.dto.CommentDTO;
import com.drathing.dto.KeywordDTO;
import com.drathing.dto.PrintDTO;
import com.drathing.dto.UserDTO;

@Mapper
public interface DrathingMapper {
	public CommentDTO selectCommentDTO(String pk );
	public List<CommentDTO> selectCommentDTOs( String value);
	public void insertCommentDTO(CommentDTO commentDTO);
	public void updateCommentDTO(CommentDTO commentDTO);
	public void deleteCommentDTO(String pk);
	
	public KeywordDTO selectKeywordDTO ();
	//public List<CommentDTO> selectKeywordDTOs ();
	public void insertKeywordDTO(KeywordDTO keywordDTO);
	public KeywordDTO selectKeywordDTOByName(String name);
	//public void updateKeywordDTO(KeywordDTO keywordDTO);
	//public void deleteKeywordDTO(String seq);
	
	public PrintDTO selectPrintDTO (String number);
	public PrintDTO selectPrintDTOPrint (String printing);
	public List<PrintDTO> selectPrintDTOs ();
	public void insertPrintDTO(PrintDTO printDTO);
	//public void updatePrintDTO(PrintDTO printDTO);
	public void deletePrintDTO(String number);
	public void updatePrintDTO(PrintDTO printDTO);
	
	public UserDTO selectUserDTO (String uid);
	//public List<UserDTO> selectUserDTOs ();
	public void insertUserDTO(UserDTO userDTO);
	//public void updateUserDTO(UserDTO userDTO);
	//public void deleteUserDTO(String uid);

	//page
	public int selectCountTotal();
	public List<PrintDTO> selectPrintDTOLimit(int start);
}
