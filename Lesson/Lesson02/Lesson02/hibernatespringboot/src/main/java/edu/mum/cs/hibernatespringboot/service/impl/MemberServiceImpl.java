package edu.mum.cs.hibernatespringboot.service.impl;

import java.util.List;

import edu.mum.cs.hibernatespringboot.dao.MemberDao;
import edu.mum.cs.hibernatespringboot.domain.Member;
import edu.mum.cs.hibernatespringboot.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional 
public class MemberServiceImpl implements MemberService {
	
 	@Autowired
	private MemberDao memberDao;

     public void save( Member member) {
  		memberDao.save(member);
 	}
  	
  	
	public List<Member> findAll() {
		return memberDao.findAll();
	}

	public Member findByMemberNumber(Integer memberId) {
/*		Member member = memberDao.findByMemberNumber(memberId);
		System.out.println("First name " + member.getFirstName());
		member.setFirstName("XXXX");
		member = memberDao.findOne(member.getId());
		System.out.println("First name " + member.getFirstName());

*/	
		return memberDao.findByMemberNumber(memberId);
	}
 

}
