package Karaokelon.Controller;

import Karaokelon.Domain.DTO.BoardDTO;
import Karaokelon.Domain.DTO.CategoryDTO;
import Karaokelon.Domain.DTO.MiddleCategoryDTO;
import Karaokelon.Domain.DTO.ReplyDTO;
import Karaokelon.Service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class BoardController {
    @Autowired
    BoardService boardService;
    @Autowired
    HttpServletRequest request;

    // 게시판 메인으로
    @GetMapping("/Board/BoardMain")
    public String goToBoardMain(Model model) {
        List<CategoryDTO> categoryDTOS = boardService.CreateCategory();
        List<MiddleCategoryDTO> middleCategoryDTOS = boardService.getMiddleC();

        model.addAttribute("Category", categoryDTOS);
        model.addAttribute("MCategory", middleCategoryDTOS);
        return "Karaokelon/Board/BoardMain";
    }

    // 글쓰기 페이지 열기
    @GetMapping("/Board/BoardWrite")
    public String goToBoardWrite() {
        return "Karaokelon/Board/BoardWrite";
    }

    // 글쓰기 페이지에 정보 가져와 넘기기
    @GetMapping("/Board/MiddleCategory")
    public String RecallMiddleCategory(@RequestParam("indexNo")int indexNo, Model model, @RequestParam("cateNo")int cateNo) {
        HttpSession session = request.getSession();
        session.setAttribute("MiddleCategorySelectNo", indexNo);
        session.setAttribute("cateNo", cateNo);

        String midCategoryName = boardService.MiddleCategoryName(indexNo+1);
        List<BoardDTO> boardDTOS = boardService.BoardList();

        model.addAttribute("Name", midCategoryName);
        model.addAttribute("BoardDTO", boardDTOS);

        return "Karaokelon/Board/MiddleCategory";
    }

    // 글쓰기
    @GetMapping("/Board/BoardW") @ResponseBody
    public String BoardWrite(@RequestParam("title")String title, @RequestParam("contents")String contents) {
        HttpSession session = request.getSession();
        int indexNo = (int)session.getAttribute("MiddleCategorySelectNo");
        boolean result = boardService.BoardWrite(title, contents, indexNo);
        if(result) {
            return "1";
        } else {
            return "0";
        }
    }

    // 글 상세보기 페이지로
    @GetMapping("/Board/BoardView")
    public String goToBoardView(Model model) {
        int bno = Integer.parseInt(request.getParameter("bno"));
        boardService.BoardViewPlus(bno);
        BoardDTO boardDTO = boardService.BoardView(bno);
        List<ReplyDTO> replyDTO = boardService.ReplyList(bno);

        model.addAttribute("ReplyDTO", replyDTO);
        model.addAttribute("BoardView", boardDTO);
        return "Karaokelon/Board/BoardView";
    }

    // 댓글쓰기
    @GetMapping("/Board/RiplyWrite") @ResponseBody
    public String ReplyWrite(@RequestParam("reply")String reply, @RequestParam("bno")int bno, @RequestParam("mno")int mno) {
        boolean result = boardService.ReplyWrite(reply, mno, bno);
        if(result) {
            return "1";
        } else {
            return "0";
        }
    }
}
