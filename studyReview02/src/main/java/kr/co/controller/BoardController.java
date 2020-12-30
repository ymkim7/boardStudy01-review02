package kr.co.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.service.BoardService;
import kr.co.service.ReplyService;
import kr.co.vo.BoardVO;
import kr.co.vo.Criteria;
import kr.co.vo.PageMaker;
import kr.co.vo.ReplyVO;
import kr.co.vo.SearchCriteria;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

	@Autowired
	private BoardService board;
	
	@Autowired
	private ReplyService reply;
	
	@RequestMapping(value = "writeView", method = RequestMethod.GET)
	public void writeGET() throws Exception {
		logger.info("writeGET");
		
	}
	
	@RequestMapping(value = "write", method = RequestMethod.POST)
	public String writePOST(BoardVO boardVO, MultipartHttpServletRequest mpRequest) throws Exception {
		logger.info("writePOST");
		
		board.write(boardVO, mpRequest);
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {
		logger.info("list");
		
		model.addAttribute("list", board.list(scri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(board.listCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "board/list";
	}
	
	@RequestMapping(value = "readView", method = RequestMethod.GET)
	public String readGET(BoardVO boardVO, Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {
		logger.info("readGET");
		
		model.addAttribute("read", board.read(boardVO.getBno()));
		model.addAttribute("scri", scri);
		
		List<ReplyVO> replyList = reply.readReply(boardVO.getBno());
		model.addAttribute("replyList", replyList);
		
		List<Map<String, Object>> fileList = board.selectFileList(boardVO.getBno());
		model.addAttribute("file", fileList);
		
		return "board/readView";
		
	}
	
	@RequestMapping(value = "updateView", method = RequestMethod.GET)
	public String updateView(BoardVO boardVO, Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {
		logger.info("updateView");
		
		model.addAttribute("update", board.read(boardVO.getBno()));
		model.addAttribute("scri", scri);
		
		List<Map<String, Object>> fileList = board.selectFileList(boardVO.getBno());
		model.addAttribute("file", fileList);
		
		return "board/updateView";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BoardVO boardVO
						,RedirectAttributes rttr
						,@ModelAttribute("scri") SearchCriteria scri
						,@RequestParam(value="fileNoDel[]") String[] files
						,@RequestParam(value="fileNameDel[]") String[] fileNames
						,MultipartHttpServletRequest mpRequest) throws Exception {
		logger.info("update");
		
		board.update(boardVO, files, fileNames, mpRequest);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(BoardVO boardVO
						,@ModelAttribute("scri") SearchCriteria scri
						,RedirectAttributes rttr) throws Exception {
		logger.info("delete");
		
		board.delete(boardVO.getBno());
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/list";
		
	}
	
	@RequestMapping(value = "replyWrite", method = RequestMethod.POST)
	public String replyWrite(ReplyVO replyVO, SearchCriteria scri
							,RedirectAttributes rttr) throws Exception {
		logger.info("replyWrite");
		
		reply.writeReply(replyVO);
		
		rttr.addAttribute("bno", replyVO.getBno());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/readView";
	}
	
	@RequestMapping(value = "replyUpdateView", method = RequestMethod.GET)
	public String replyUpdateView(ReplyVO replyVO, Model model, SearchCriteria scri) throws Exception {
		logger.info("replyUpdateView");
		
		model.addAttribute("replyUpdate", reply.selectReply(replyVO.getRno()));
		model.addAttribute("scri", scri);
		
		return "board/replyUpdateView";
	}
	
	@RequestMapping(value = "replyUpdate", method = RequestMethod.POST)
	public String replyUpdate(ReplyVO replyVO
						,SearchCriteria scri
						,RedirectAttributes rttr) throws Exception {
		logger.info("replyUpdate");
		
		reply.updateReply(replyVO);
		
		rttr.addAttribute("bno", replyVO.getBno());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/readView";
	}
	
	@RequestMapping(value = "replyDeleteView", method = RequestMethod.GET)
	public String replyDeleteView(ReplyVO replyVO, Model model, SearchCriteria scri) throws Exception {
		logger.info("replyDeleteView");
		
		model.addAttribute("replyDelete", reply.selectReply(replyVO.getRno()));
		model.addAttribute("scri", scri);
		
		return "board/replyDeleteView";
	}
	
	@RequestMapping(value = "replyDelete", method = RequestMethod.POST)
	public String replyDelete(ReplyVO replyVO
						,SearchCriteria scri
						,RedirectAttributes rttr) throws Exception {
		logger.info("replyDelete");
		
		reply.deleteReply(replyVO);
		
		rttr.addAttribute("bno", replyVO.getBno());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/readView";
	}
	
	@RequestMapping(value = "/fileDown")
	public void fileDown(@RequestParam Map<String, Object> map
						,HttpServletResponse response) throws Exception {
		logger.info("fileDown");
		
		Map<String, Object> resultMap = board.selectFileInfo(map);
		String storedFileName = (String) resultMap.get("STORED_FILE_NAME");
		String originalFileName = (String) resultMap.get("ORG_FILE_NAME");
		
		//파일을 저장했던 위치에서 첨부파일을 읽어 byte[] 형식으로 변환하다.
		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\file\\" + storedFileName));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(originalFileName, "UTF-8") + "\";");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
	}
	
}
