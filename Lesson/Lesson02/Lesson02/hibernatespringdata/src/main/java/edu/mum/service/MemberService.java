package edu.mum.service;

import java.util.List;

import edu.mum.domain.Member;

public interface MemberService {

    void save(Member member);

    List<Member> findAll();

    Member findByMemberNumber(Integer memberId);
}
