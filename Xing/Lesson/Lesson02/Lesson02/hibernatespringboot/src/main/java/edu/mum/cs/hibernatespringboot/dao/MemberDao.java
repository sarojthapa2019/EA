package edu.mum.cs.hibernatespringboot.dao;


import edu.mum.cs.hibernatespringboot.domain.Member;

public interface MemberDao extends GenericDao<Member> {
      
	public Member findByMemberNumber(Integer number);
}
