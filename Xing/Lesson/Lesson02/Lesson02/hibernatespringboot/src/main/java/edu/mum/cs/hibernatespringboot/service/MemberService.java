package edu.mum.cs.hibernatespringboot.service;

import edu.mum.cs.hibernatespringboot.domain.Member;

import java.util.List;


public interface MemberService {

	public void save(Member member);
	public List<Member> findAll();
	public Member findByMemberNumber(Integer memberId);
}
