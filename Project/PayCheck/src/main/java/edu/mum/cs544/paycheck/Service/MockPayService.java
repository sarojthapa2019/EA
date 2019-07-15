package edu.mum.cs544.paycheck.Service;

import edu.mum.cs544.paycheck.Domain.Account;
import edu.mum.cs544.paycheck.Domain.Result;
import edu.mum.cs544.paycheck.Domain.Transaction;

import java.util.List;

public class MockPayService implements PayService{
    @Override
    public boolean transact(Account account) {
        return true;
    }

    @Override
    public List<Transaction> getTrans(int accId) {
        return null;
    }
}
