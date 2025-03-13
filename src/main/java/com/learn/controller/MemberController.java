package com.learn.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.entity.Member;
import com.learn.repository.MemberRepository;
import com.learn.service.MemberService;

@RestController
@RequestMapping("/members")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping
	public List<Member> getAllMembers(){
		List<Member> result = new ArrayList<>();
		
		result = memberService.getAllMembers();
		
//		Map<String,Object> elem1 = new HashMap<>();
//		elem1.put("name", "Member1");
//		elem1.put("email","abc@test.com");
//		
//		Map<String,Object> elem2 = new HashMap<>();
//		elem2.put("name", "Member2");
//		elem2.put("email","abc2@test.com");
//		
//		result.add(elem1);
//		result.add(elem2);
		
		return result; 
		
	}
	
	
	@PostMapping
	public Member createMember(@RequestBody Member member){
		Member result = null;
		result = memberService.createMember(member);
//		result.put("name", "createMember");
//		result.put("email","create@test.com");
		return result;
	}
	
	@GetMapping("/{id}")
	public Member getMemberById(@PathVariable String id){
		Member result = null;
//		result.put("name", id);
//		result.put("email", "memberByID@test.com");
		result = memberService.getMemberById(id);
		return result;
	}
	
	@PostMapping("/modify/{id}")
	public Member updateMember(@PathVariable String id, @RequestBody Member member){
		Member result = null;
//		result.put("name", id);
//		result.put("email", "update@test.com");
		result = memberService.updateMember(id, member);
		return result;
		
	}
	
	@GetMapping("/delete/{id}")
	public Member deleteMamber(@PathVariable String id){
		Member result = null;
		result = memberService.deleteMember(id);
		return result;
	}
	
	
	@GetMapping("/active")
	public List<Member> activeMember(){
		List<Member> result = null;
		result = memberService.activeMember();
		return result;
		
	}
	
	@GetMapping("/active2")
	public List<Member> activeMember2(){
		List<Member> result = null;
		result = memberService.activeMember2();
		return result;
		
	}
	
	
	@GetMapping("/active3")
	public List<Member> activeMember3(){
		List<Member> result = null;
		result = memberService.activeMember3();
		return result;
		
	}
	
	
	
	
	

}
