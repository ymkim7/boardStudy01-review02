package kr.co.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import kr.co.service.RecodeService;
import kr.co.vo.BoardVO;
import kr.co.vo.RecodeEduVO;
import kr.co.vo.RecodeVO;

@Controller
@RequestMapping(value = "/recode/*")
public class RecodeController {
	
	private static final Logger logger = LoggerFactory.getLogger(RecodeController.class);
	
	@Autowired
	private RecodeService recode;
	
	@RequestMapping(value = "recodeCard", method = RequestMethod.GET)
	public void GetRecodeCard() throws Exception {
		logger.info("GetRecodeCard");
		
	}
	
	@RequestMapping(value = "recodeCard", method = RequestMethod.POST)
	public String PostRecodeCard(RecodeVO recodeVO, RecodeEduVO recodeEduVO) throws Exception {
		logger.info("PostRecodeCard");
		
		recode.insertRecodeEdu(recodeEduVO);
		recode.insertRecode(recodeVO);
		
		return "redirect:/recode/recodeCard";
	}

}
