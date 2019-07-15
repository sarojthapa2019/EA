package edu.mum.cs544.paycheck.Service;

import edu.mum.cs544.paycheck.Domain.Account;
import edu.mum.cs544.paycheck.Domain.Result;
import edu.mum.cs544.paycheck.Domain.Transaction;

import java.util.List;

public interface PayService {

    public boolean transact(Account account);

    public List<Transaction> getTrans(int accId);
}
