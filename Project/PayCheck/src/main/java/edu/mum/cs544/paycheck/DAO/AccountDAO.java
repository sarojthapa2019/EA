package edu.mum.cs544.paycheck.DAO;

import edu.mum.cs544.paycheck.Domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDAO extends JpaRepository<Account,Integer> {
}
