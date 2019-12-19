package edu.mum.cs.hibernatespringboot.dao.impl;


import javax.persistence.Query;

import edu.mum.cs.hibernatespringboot.dao.MemberDao;
import edu.mum.cs.hibernatespringboot.domain.Member;
import org.springframework.stereotype.Repository;


@Repository
public class MemberDaoImpl extends GenericDaoImpl<Member> implements MemberDao {

    public MemberDaoImpl() {
        super.setDaoType(Member.class);
    }

    public Member findByMemberNumber(Integer number) {

        Query query = entityManager.createQuery("select m from MEMBER m  where m.memberNumber =:number");
        return (Member) query.setParameter("number", number).getSingleResult();

    }


}