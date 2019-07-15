package edu.mum.cs544.paycheck.Domain;

import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue
    private int id;
    private int accNo;
    @ColumnTransformer(read = "DES_DECRYPT(password, Encryptionkey)", write = "DES_ENCRYPT(?,password)")
    private String password;
    private String FName;
    private String LName;
    private double balance;
    private Date lastUpdate;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Transaction> transactions = new ArrayList<>();

    @Transient
    private String Encryptionkey = "Maharishi";

    public int getId() {
        return id;
    }

    public int getAccNo() {
        return accNo;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransactions(Transaction trans) {
        this.transactions.add(trans);
        trans.setAccount(this);
    }

    public String getEncryptionkey() {
        return Encryptionkey;
    }
}
