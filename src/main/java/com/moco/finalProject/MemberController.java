package com.moco.finalProject;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.moco.file.FileManager;
import com.moco.fileTest.FileSaver;
import com.moco.member.MemberDTO;
import com.moco.member.MemberService;
import com.moco.util.RowMaker;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@RequestMapping(value="memberJoin", method=RequestMethod.GET)
	public void memberJoin(){
		System.out.println("- MemberController -> Join1");
	}
	
	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String memberJoin(MemberDTO memberDTO, MultipartFile f1, HttpSession session, RedirectAttributes redirectAttributes){
		System.out.println("- MemberController -> Join2");
		
		String message = "회원가입 실패";
		int result = 0;
		// oname 셋팅
		memberDTO.setOname(f1.getOriginalFilename());
		FileSaver fileSaver = new FileSaver();
		try {
			// fname 셋팅/ 업로드
			String path = session.getServletContext().getRealPath("resources/upload/member");
			System.out.println("파일경로 : "+path);
			
			memberDTO.setFname(fileSaver.saver(f1, path));
			result = memberService.memberJoin(memberDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0){
			message = "회원가입 성공";
		}
		
		redirectAttributes.addFlashAttribute("message", message);
		return "redirect:/";
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.GET)
	public void memberLogin(){
		
	}
	
	@RequestMapping(value="memberLogin", method=RequestMethod.POST)
	public String memberLogin(MemberDTO memberDTO, HttpSession session, RedirectAttributes redirectAttributes){
		System.out.println("- MemberController -> Join");
		
		String message = "Login Failed";
		
		try {
			memberDTO = memberService.memberLogin(memberDTO);
			message = "Login Success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		session.setAttribute("memberDTO", memberDTO);
		redirectAttributes.addFlashAttribute("message", message);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="memberLogout", method=RequestMethod.GET)
	public String memberLogout(HttpSession session){
		session.invalidate();
		
		return "redirect:/";
	}
	
	@RequestMapping(value="memberView", method=RequestMethod.GET)
	public void memberView(HttpSession session, Model model){
		System.out.println("- MemberController -> View");
		
		MemberDTO memberDTO = null;
		
		try {
			memberDTO = memberService.memberView((MemberDTO)session.getAttribute("memberDTO"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("memberDTO", memberDTO);
	}
	
	@RequestMapping(value="memberDelete", method=RequestMethod.GET)
	public String memberDelete(HttpSession session, RedirectAttributes redirectAttributes){
		System.out.println("- MemberController -> Delete");
		
		String message = "Member Delete Fail";
		int result = 0;
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("memberDTO");
		
		System.out.println("id : "+memberDTO.getId());
		
		try {
			result = memberService.memberDelete(memberDTO.getId());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result>0){
			message = "Member Delete Success";
			session.invalidate();
		}
		redirectAttributes.addFlashAttribute("message", message);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="managementDelete", method=RequestMethod.GET)
	public String managementDelete(String id, RedirectAttributes redirectAttributes){
		int result = 0;
		String message = "Member Delete Fail";
		
		try {
			result = memberService.memberDelete(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(result>0){
			message = "Member Delete Success";
		}
		
		redirectAttributes.addFlashAttribute("message", message);
		
		return "";
	}

	
	@RequestMapping(value="memberUpdate", method=RequestMethod.GET)
	public void memberUpdate(HttpSession session, Model model){
		System.out.println("- MemberController -> Update1");
		
		MemberDTO memberDTO = null;
		
		try {
			memberDTO = memberService.memberView((MemberDTO)session.getAttribute("memberDTO"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		model.addAttribute("memberDTO", memberDTO);
	}
	
	@RequestMapping(value="memberUpdate", method=RequestMethod.POST)
	public String memberUpdate(MemberDTO memberDTO, MultipartFile f1, HttpSession session, RedirectAttributes redirectAttributes){
		System.out.println("- MemberController -> Update2");
		
		String message = "Member Update Fail";
		int result = 0;
		FileSaver fileSaver = new FileSaver();
		
		if(!f1.getOriginalFilename().equals("")){
			System.out.println("사진이 있습니다.");
			//oname 세팅
			memberDTO.setOname(f1.getOriginalFilename());
		
			try {
				String path = session.getServletContext().getRealPath("resources/upload/member");

				System.out.println("파일경로 : "+path);
				// 파일 업로드
				memberDTO.setFname(fileSaver.saver(f1, path));
				
				// 정보 업데이트
				result = memberService.memberUpdate(memberDTO);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("사진이 없습니다.");
			memberDTO.setFname(" ");
			memberDTO.setOname(" ");
			try {
				result = memberService.memberUpdate(memberDTO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(result>0){
			message="Member Update Success";
		}
		
		redirectAttributes.addFlashAttribute("message", message);
		session.setAttribute("memberDTO", memberDTO);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="memberIdCheck", method=RequestMethod.POST)
	public String memberIdCheck(String id, Model model){
		System.out.println("- MemberController -> IdCheck");
		
		boolean check = false;
		
		System.out.println("Checking ID : "+id);
		
		try {
			check = memberService.memberIdCheck(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String message = "이미 존재하는 아이디입니다.";
		
		if(check == true){
			message = "사용가능한 아이디 입니다.";
		}
		
		model.addAttribute("message", message);
		
		return "/member/action/memberIdCheckResult";
	}
	
	@RequestMapping(value="memberFileDelete", method=RequestMethod.POST)
	public String MemberFileDelete(MemberDTO memberDTO, HttpSession session){
		System.out.println("- MemberController -> MemberFileDelete");
		
		FileManager fileManager = new FileManager();		
		fileManager.fileDelete(session.getServletContext().getRealPath("resources/upload/member"), memberDTO.getFname());
		
		try {
			memberService.memberFileDelete(memberDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "/member/action/memberFileDelete";
	}
	
	@RequestMapping(value="memberManagement", method=RequestMethod.GET)
	public void MemberList(Integer curPage, @RequestParam(required=false)String search, Model model){
		System.out.println("- MemberController -> List");
		
		try {
			if(curPage == null){
				curPage = 1;
			}
			if(search == null){
				search="%";
			}
			
			Map<String, Object> map = memberService.memberList(curPage, search);
			model.addAttribute("list", map.get("list"));
			model.addAttribute("pageResult",map.get("pageResult"));
			model.addAttribute("curPage",curPage);
			model.addAttribute("search", search);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}