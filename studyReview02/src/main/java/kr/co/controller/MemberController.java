package kr.co.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.service.MemberService;
import kr.co.vo.MemberVO;

@Controller
@RequestMapping(value = "/member/*")
public class MemberController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService member;
	
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;
	
	//회원가입GET
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public void getRegister() throws Exception {
		logger.info("getRegister");
		
	}
	
	//회원가입POST
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String postRegister(MemberVO memberVO) throws Exception {
		logger.info("postRegister");
		
		int result = member.idChk(memberVO);
		
		try {
			if(result == 1) {
				return "/member/register";
			} else if(result == 0) {
				String inputPass = memberVO.getUserPass();
				String pwd = pwdEncoder.encode(inputPass);
				memberVO.setUserPass(pwd);
				
				member.register(memberVO);
			}
		} catch(Exception e) {
			throw new RuntimeException();
		}
		
		return "redirect:/";
	}
	
	//로그인
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(MemberVO memberVO, HttpSession session
						,RedirectAttributes rttr) throws Exception {
		logger.info("login");
		
		session.getAttribute("member");
		MemberVO login = member.login(memberVO);
		boolean pwdMatch = pwdEncoder.matches(memberVO.getUserPass(), login.getUserPass());
		
		if(login != null && pwdMatch == true) {
			session.setAttribute("member", login);
		} else {
			session.setAttribute("member", null);
			rttr.addFlashAttribute("msg", false);
		}
		
		return "redirect:/";
	}
	
	//로그아웃
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		logger.info("logout");
		
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "memberUpdateView", method = RequestMethod.GET)
	public String memberUpdateView() throws Exception {
		logger.info("memberUpdateView");
		
		return "member/memberUpdateView";
	}
	
	@RequestMapping(value = "/memberUpdate", method = RequestMethod.POST)
	public String memberUpdate(MemberVO memberVO, HttpSession session) throws Exception {
		logger.info("memberUpdate");
		
		member.memberUpdate(memberVO);
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "memberDeleteView", method = RequestMethod.GET)
	public String memberDeleteView() throws Exception {
		logger.info("memberDeleteView");
		
		return "member/memberDeleteView";
	}
	
	@RequestMapping(value = "memberDelete", method = RequestMethod.POST)
	public String memberDelete(MemberVO memberVO, HttpSession session, RedirectAttributes rttr) throws Exception {
		logger.info("memberDelete");
		
		member.memberDelete(memberVO);
		session.invalidate();
		
		return "redirect:/";
	}
	
	//패스워드 체크
	@ResponseBody
	@RequestMapping(value = "passChk", method = RequestMethod.POST)
	public boolean passChk(MemberVO memberVO) throws Exception {
		logger.info("passChk");
		
		MemberVO login = member.login(memberVO);
		boolean pwdChk = pwdEncoder.matches(memberVO.getUserPass(), login.getUserPass());
		
		return pwdChk;
	}
	
	//아이디 체크
	@ResponseBody
	@RequestMapping(value = "idChk", method = RequestMethod.POST)
	public int idChk(MemberVO memberVO) throws Exception {
		logger.info("idChk");
		
		int result = member.idChk(memberVO);
		
		return result;
	}

}
