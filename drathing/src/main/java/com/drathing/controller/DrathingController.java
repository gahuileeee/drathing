package com.drathing.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.drathing.dto.CommentDTO;
import com.drathing.dto.KeywordDTO;
import com.drathing.dto.UserDTO;
import com.mysql.cj.Session;
import com.mysql.cj.xdevapi.JsonValue;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.drathing.dto.PrintDTO;
import com.drathing.service.DrathingService;


@Controller
public class DrathingController {
	private final DrathingService service;
	
	@Autowired
	private DrathingController(DrathingService service) {
		this.service=service;
	}
	
	//main
	@GetMapping(value = {"/index","/"})
	public String index() {
		return "/index";
	}

	//회원가입
	@PostMapping("/register")
	public String register(UserDTO userDTO , @RequestParam(value = "lg", required = false) String lg,
						   @RequestParam(value = "pg", required = false) String pg ,Model model){
		List<String> msg = new ArrayList<>();
		if(!isValidEmail(userDTO.getUid())) {
			msg.add("올바른 이메일 형식이 아닙니다.");
		}
		if(!userDTO.getCpassword().equals(userDTO.getUpassword())){
			msg.add("입력한 비밀번호가 일치하지 않습니다.");
		}
		if(service.selectUserDTO(userDTO.getUid())!=null){
			msg.add("이미 가입된 이메일입니다.");
		}
		model.addAttribute("msg",msg);
		model.addAttribute("lg",lg);
		model.addAttribute("pg",pg);
		if(msg.size()==0){
			service.insertUserDTO(userDTO);
			return "redirect:/login";
		}
		for(String a:msg){
			System.out.println(a);
		}
		return "/registerForm";
	}

	@GetMapping("/register")
	public  String register( @RequestParam(value = "lg", required = false) String lg,
							 @RequestParam(value = "pg", required = false) String pg, Model model){
		model.addAttribute("lg",lg);
		model.addAttribute("pg",pg);
		return "/registerForm";
	}

	//로그인 선택창
	@GetMapping("/login/select")
	public String loginselect( @RequestParam(value = "lg", required = false) String lg,
							   @RequestParam(value = "pg", required = false) String pg ,Model model) {
		model.addAttribute("lg",lg);
		model.addAttribute("pg",pg);
		return "/loginselect";
	}


	//로그인창
	@GetMapping("/login")
	public String login(@RequestParam(value = "lg", required = false) String lg,
						@RequestParam(value = "pg", required = false) String pg, Model model){
		model.addAttribute("lg",lg);
		model.addAttribute("pg",pg);
		return "/login";
	}

	@PostMapping("/login")
	public  String login(UserDTO user, Model model, HttpServletRequest request,
						 @RequestParam(value = "lg", required = false) String lg,
						 @RequestParam(value = "pg", required = false)String pg){
		String uid = user.getUid();
		String upassword = user.getUpassword();
		String msg =null;
		if(isValidEmail(uid)){
			UserDTO userDTO = service.selectUserDTO(uid);
			if(userDTO != null){
				if(userDTO.getUpassword().equals(upassword)){
					HttpSession session = request.getSession();
					session.setAttribute("user",user.getUid());
					session.setMaxInactiveInterval(60*60);
					if(lg !=null){
						if(lg!= ""){
							return "redirect:/board?pg="+pg;
						}else{
							return  "/keyword";
						}
					}else{
						return  "/keyword";
					}
				}else{
					 msg = "비밀번호가 다릅니다";
				}
			}else{
				msg = "등록되지 않은 이메일입니다";
			}
		}else{
			msg = "유효하지 않은 이메일 형식입니다";
		}
		model.addAttribute("msg",msg);
		model.addAttribute("lg",lg);
		model.addAttribute("pg",pg);
		return  "/login";
	}

	public static boolean isValidEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
				"(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(emailRegex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpServletRequest request,
	@RequestParam(value = "k", required = false) String k,
						 @RequestParam(value = "pg", required = false)String pg, Model model){
		HttpSession session = request.getSession();
		session.invalidate();
		if(k!=null ){
			return  "/loginselect";
		}
		return "redirect:board?pg="+pg;
	}

	//키워드 선택
	@GetMapping("/keyword")
	public String keyword(){
		return "/keyword";
	}

	// keyword create
	@GetMapping("/create")
	public  String create(){
		return "/create";
	}

	//그림 그리기
	@GetMapping("/drawing")
	public String drawing(Model model){
		KeywordDTO keywordDTO = service.selectKeywordDTO();
		model.addAttribute("key",keywordDTO.getName());
		return "/drawing";
	}

	@PostMapping("/drawing")
	public String drawing(@RequestParam("key") String name, Model model){
		KeywordDTO keywordDTO = service.selectKeywordDTOByName(name);
		if(keywordDTO == null){
			keywordDTO= new KeywordDTO();
			keywordDTO.setName(name);
			service.insertKeywordDTO(keywordDTO);
		}
		model.addAttribute("key",name);
		return "/drawing";
	}


	//게시판 (board)
	@GetMapping("/board")
	public String board(Model model, @RequestParam(value = "pg", required = false) String pg) {
		int currentPg= 1;
		if (pg == null || pg == ""){
			pg= "1";
		}else{
			currentPg=Integer.parseInt(pg);
		}

		//전체 글 갯수
		int total = service.selectCountTotal();

		//마지막 페이지 번호 계산
		int lastPageNum=(total/12);
		if(total%12==0){
		}else{
			lastPageNum+=1;
		}
		//limit 시작값 계산
		int start =12*(currentPg-1);
		List<PrintDTO> prints =service.selectPrintDTOLimit(start);

		//페이지번호 그룹 계산
		int pageGroupCurrent =(int) Math.ceil(currentPg/12.0);
		int pageGroupStart = (pageGroupCurrent-1)*12+1;
		if(pageGroupStart<=0){
			pageGroupStart=1;
		}
		int pageGroupEnd   = pageGroupCurrent*12;

		if(pageGroupEnd >lastPageNum){
			pageGroupEnd=lastPageNum;
		}
		//페이지 시작 번호 계산
		int pageStartNum = total-start;
		model.addAttribute("pageStartNum", pageStartNum);
		model.addAttribute("currentPg", currentPg);
		model.addAttribute("pageGroupStart", pageGroupStart);
		model.addAttribute("pageGroupEnd", pageGroupEnd);
		model.addAttribute("lastPageNum", lastPageNum);
		model.addAttribute("prints", prints);
		return "/board";
	}
	
	//게시판으로 그림 들고 오는 경우
	@PostMapping("/board")
	public String board(@RequestParam(name = "drawingData")String drawingData,
			@RequestParam(name = "key")String key,Model model, HttpServletRequest request) {
		 String[] parts = drawingData.split(",");
		 PrintDTO print = new PrintDTO();
			 String user= String.valueOf(request.getSession().getAttribute("user"));
			 if(user.equals("null")) {
				 user="guest";
			 }
			 print.setUser(user);
			 print.setName(key);
			 print.setPrinting(parts[1]);
			 service.insertPrintDTO(print);
			model.addAttribute("pg","1");
		return "redirect:/board";
	}

	
	//게시물
	@GetMapping("/bulletin")
	public String bulletin(Model model, @RequestParam("number") String number, @RequestParam(value = "pg", required = false)String  pg){
		PrintDTO printDTO = service.selectPrintDTO(number);
		List<CommentDTO> lists = service.selectCommentDTOs(number);
		model.addAttribute("print",printDTO);
		model.addAttribute("lists", lists);
		model.addAttribute("pg",pg);
		return "/bulletin";
	}

	//좋아요
	@PostMapping("/like")
	public  String like(Model model,
						@RequestParam("number") String number,
						@RequestParam("like")String like){
		PrintDTO printDTO = service.selectPrintDTO(number);
		int nlike = Integer.parseInt(like)+1;
		printDTO.setLike(String.valueOf(nlike));
		service.updatePrintDTO(printDTO);
		return "redirect:/bulletin?number="+number;
	}

	//댓글

	@PostMapping("/comment")
	public  String comment(Model model, @RequestParam("comment") String comment,
						   @RequestParam("number") String number, HttpServletRequest request){
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		if(user == null){
			user="guest";
		}
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setComment_id(user);
		commentDTO.setContent(comment);
		commentDTO.setNumber(number);

		service.insertCommentDTO(commentDTO);
		return "redirect:/bulletin?number="+number;
	}


}
