package edu.mum.cs544.paycheck.Service;

import edu.mum.cs544.paycheck.DAO.AccountDAO;
import edu.mum.cs544.paycheck.DAO.TransactionDAO;
import edu.mum.cs544.paycheck.Domain.Account;
import edu.mum.cs544.paycheck.Domain.Result;
import edu.mum.cs544.paycheck.Domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PayServiceImpl implements PayService {
    @Autowired
    private AccountDAO accountDAO;

    @Autowired
    private TransactionDAO transactionDAO;

    @Override
    public boolean transact(Account account) {
        return false;
    }

    @Override
    public List<Transaction> getTrans(int accId) {
        return null;
    }
}
