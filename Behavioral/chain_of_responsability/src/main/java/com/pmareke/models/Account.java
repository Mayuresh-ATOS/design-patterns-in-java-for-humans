package com.pmareke.models;

public abstract class Account {
    private Account successor;
    protected float balance;

    public void setNext(Account account) {
        this.successor = account;
    }

    public void pay(float amountToPay) throws Exception {
        if (this.canPay(amountToPay)) {
            System.out.println(String.format("Paid %s using %s", amountToPay, this.getClass().getSimpleName()));
        } else if (this.successor != null) {
            System.out.println(String.format("Cannot pay using %s, proceeding..", this.getClass().getSimpleName()));
            this.successor.pay(amountToPay);
        } else {
            throw new Exception("None of the accounts have enough balance");
        }
    }

    public boolean canPay(float amount) {
        return this.balance >= amount;
    }
}
