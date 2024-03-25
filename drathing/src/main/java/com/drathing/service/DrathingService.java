package com.drathing.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.eclipse.tags.shaded.org.apache.regexp.recompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drathing.dto.CommentDTO;
import com.drathing.dto.KeywordDTO;
import com.drathing.dto.PrintDTO;
import com.drathing.dto.UserDTO;
import com.drathing.mapper.DrathingMapper;

@Service
public class DrathingService {
	private final DrathingMapper mapper;
	
	@Autowired
	private DrathingService(DrathingMapper mapper) {
		this.mapper=mapper;
	}
	
	public CommentDTO selectCommentDTO(String pk ){
		return mapper.selectCommentDTO(pk);
	};
	public List<CommentDTO> selectCommentDTOs( String value){
		return mapper.selectCommentDTOs(value);
	};
	public void insertCommentDTO(CommentDTO commentDTO) {
		mapper.insertCommentDTO(commentDTO);
	};
	public void updateCommentDTO(CommentDTO commentDTO) {
		mapper.updateCommentDTO(commentDTO);
	};
	public void deleteCommentDTO(String pk) {
		mapper.deleteCommentDTO(pk);
	};
	
	//keyword
	public KeywordDTO selectKeywordDTO () {
		return mapper.selectKeywordDTO();
	};
	public void insertKeywordDTO(KeywordDTO keywordDTO) {
		mapper.insertKeywordDTO(keywordDTO);
	};

	public  KeywordDTO selectKeywordDTOByName(String name){
		return mapper.selectKeywordDTOByName(name);
	};

	
	//print
	public PrintDTO selectPrintDTO (String number) {
		return mapper.selectPrintDTO(number);
	};
	public PrintDTO selectPrintDTOPrint (String printing) {
		return mapper.selectPrintDTOPrint(printing);
	};
	public List<PrintDTO> selectPrintDTOs (){
		return mapper.selectPrintDTOs();
	};
	public void insertPrintDTO(PrintDTO printDTO) {
		mapper.insertPrintDTO(printDTO);
	};
	public void deletePrintDTO(String number) {
		mapper.deletePrintDTO(number);
	};

	public  void updatePrintDTO(PrintDTO printDTO){
		mapper.updatePrintDTO(printDTO);
	}
	
	
	//user
	public UserDTO selectUserDTO (String uid) {
		return mapper.selectUserDTO(uid);
	};
	public void insertUserDTO(UserDTO userDTO) {
		mapper.insertUserDTO(userDTO);
	};

	//page
	public int selectCountTotal(){
		return mapper.selectCountTotal();
	};
	public List<PrintDTO> selectPrintDTOLimit(int start){
		return mapper.selectPrintDTOLimit(start);
	};

}

