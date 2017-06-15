package com.moco.member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.moco.util.RowMaker;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String namespace = "MemberMapper.";

	public int memberJoin(MemberDTO memberDTO) throws Exception{
		System.out.println("--- MemberDAO -> Join");
		
		int result = sqlSession.insert(namespace+"memberJoin", memberDTO);
		
		return result;
	}
	
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception{
		System.out.println("--- MemberDAO -> Login");
		
		return sqlSession.selectOne(namespace+"memberLogin", memberDTO);
	}
	
	public MemberDTO memberView(MemberDTO memberDTO) throws Exception{
		System.out.println("--- MemberDAO -> View");
		
		return sqlSession.selectOne(namespace+"memberView", memberDTO);
	}

	public int memberDelete(String id){
		System.out.println("--- MemberDAO -> Delete");
		
		int result = sqlSession.delete(namespace+"memberDelete", id);
		
		return result;
	}
	
	public int memberUpdate(MemberDTO memberDTO){
		System.out.println("--- MemberDAO -> Update");
		
		int result = sqlSession.update(namespace+"memberUpdate", memberDTO); 
		
		return result;
	}
	
	public boolean memberIdCheck(String id){
		System.out.println("--- MemberDAO -> IdCheck");

		boolean flag = false;
		String checkId = "";
		
		checkId = sqlSession.selectOne(namespace+"memberIdCheck", id);
		
		System.out.println("DAO Id : "+checkId);
		
		if(checkId == null){
			flag = true;
			System.out.println(flag);
		}
		
		return flag;
	}
	
	public int memberFileDelete(MemberDTO memberDTO){
		System.out.println("--- MemberDAO -> fileDelete");
		
		int result = sqlSession.update(namespace+"memberFileDelete", memberDTO);
		
		return result;
	}
	
	public List<MemberDTO> memberList(RowMaker rowMaker, String search){
		System.out.println("--- MemberDAO -> List");
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("row", rowMaker);
		map.put("search", search);
		
		return sqlSession.selectList(namespace+"memberList", map);
	}
	
	public int memberCount(String search) throws Exception {
		System.out.println("--- MemberDAO -> Count");
		
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("search", search);
		
		return sqlSession.selectOne(namespace+"memberCount",map);
	}
}
