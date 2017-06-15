package com.moco.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moco.file.FileManager;
import com.moco.util.PageMaker;
import com.moco.util.PageResult;
import com.moco.util.RowMaker;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	public int memberJoin(MemberDTO memberDTO) throws Exception{
		System.out.println("-- MemberService -> Join");
		
		int result = memberDAO.memberJoin(memberDTO);
		
		return result;
	}
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		System.out.println("-- MemberService -> Login");
		
		return memberDAO.memberLogin(memberDTO);
	}
	
	public MemberDTO memberView(MemberDTO memberDTO) throws Exception{
		System.out.println("-- MemberService -> View");
		
		return memberDAO.memberView(memberDTO);
	}
	
	public int memberDelete(String id) throws Exception{
		System.out.println("-- MemberService -> Delete");
		
		return memberDAO.memberDelete(id);
	}
	
	public int memberUpdate(MemberDTO memberDTO) throws Exception{
		System.out.println("-- MemberService -> Update");
		
		return memberDAO.memberUpdate(memberDTO);
	}
	
	public boolean memberIdCheck(String id) throws Exception{
		System.out.println("-- MemberService -> IdCheck");
		
		return memberDAO.memberIdCheck(id);
	}
	
	public int memberFileDelete(MemberDTO memberDTO) throws Exception{
		System.out.println("-- MemberService -> FileDelete");
		
		return memberDAO.memberFileDelete(memberDTO);
	}
	
	public Map<String, Object> memberList(int curPage, String search) throws Exception{
		System.out.println("-- MemberService -> List");
		
		Map<String, Object> map = new HashMap<String, Object>();
		PageMaker pageMaker = new PageMaker(curPage);
		RowMaker rowMaker = pageMaker.getRowMaker();
		PageResult pageResult = pageMaker.paging(memberDAO.memberCount(search));
		
		map.put("list", memberDAO.memberList(rowMaker, search));
		map.put("pageResult", pageResult);
		
		return map;
	}
}
