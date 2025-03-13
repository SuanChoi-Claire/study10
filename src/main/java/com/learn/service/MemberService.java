package com.learn.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.entity.Member;
import com.learn.repository.MemberRepository;

@Service
public class MemberService {
	
	
	private final String DELETE_FLAG = "retire";
	
	@Autowired
	private MemberRepository memberRepository ;
	
//	private final MemberRepository memberRepository;
//	MemberService(MemberRepository memberRepository){
//		this.memberRepository = memberRepository;
//	}
	
	
	public List<Member>getAllMembers() {
		List<Member> result =null;
		result = memberRepository.findAll();
		return result;
	}
	
	public Member createMember(Member member) {
		Member result = null;
		result = memberRepository.save(member);
		return  result;
	}
	
	
	public Member getMemberById(String id) {
		Member result = null;
		Member empthReault = new Member();
		empthReault.setName("No Name");
		empthReault.setPhone("No Phone");
		empthReault.setEmail("No Email");
		result = memberRepository.findById(id).orElse(empthReault);
		return result;
		
	}
	
	public Member updateMember(String id, Member memberDetals) {
		Member result = null;
		result = memberRepository.findById(id).map(member ->{
		member.setName(memberDetals.getName());
		member.setPhone(memberDetals.getPhone());
		return memberRepository.save(member);		
		}).orElseThrow(()->new RuntimeException("잘못된 아이디 입니다."));
		return result;
	}
	
	public Member deleteMember(String id){
		Member result = null;
		result = memberRepository.findById(id).map(member->{
			member.setUser_status(DELETE_FLAG);
			return memberRepository.save(member);
		}).orElseThrow(()-> new RuntimeException("잘못된 아이디 입니다."));
		return result;
	}
	
	//필터사용
	public List<Member> activeMember() {
		
		List<Member> result = memberRepository.findAll();
		List<Member> activeMembers = result.stream().filter(member -> "active".equals(member.getUser_status()))
		.collect(Collectors.toList());
		
		return activeMembers;
	}
	
	//for문사용
	public List<Member> activeMember2(){
		
		List<Member> resultTemp = null;
		List<Member> result = new ArrayList<>();
		
		resultTemp = memberRepository.findAll();
		
		for(int i = 0 ; i < resultTemp.size(); i++) {
			Member temp = resultTemp.get(i);
			if("active".equals(temp.getUser_status())) {
				result.add(temp);
			}
		}
		return result;
		
	}
	
	//boolean사용
public List<Member> activeMember3() {
		
		List<Member> result = memberRepository.findAll();
		List<Member> activeMembers = result.stream().filter(member -> 
		{ boolean cond1 ="active".equals(member.getUser_status());
			boolean cond2 = false;
			return cond1 && ! cond2;
		})
		.collect(Collectors.toList());
		
		return activeMembers;
	}
	
	
	
	
	
	
	
	
	
	
}
