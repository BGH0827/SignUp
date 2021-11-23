package com.mycompany.subject.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.subject.member.model.dao.MemberDao;
import com.mycompany.subject.member.model.vo.Member;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberDao memberDao;
	
	@Override
	public int signUp(Member member) {
		int result = 0;
		try {
			result = memberDao.signUp(member);
			System.out.println("service" + result);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}