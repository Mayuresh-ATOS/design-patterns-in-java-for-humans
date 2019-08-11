package com.pmareke;

import com.pmareke.models.Bank;
import com.pmareke.models.Bitcoin;
import com.pmareke.models.Paypal;

public class App {
    public static void main(String[] args) throws Exception {
        // Let's prepare a chain like below
        //      $bank->$paypal->$bitcoin
        //
        // First priority bank
        //      If bank can't pay then paypal
        //      If paypal can't pay then bit coin

        Bank bank = new Bank(100); // Bank with balance 100
        Paypal paypal = new Paypal(200); // Paypal with balance 200
        Bitcoin bitcoin = new Bitcoin(300); // Bitcoin with balance 300

        bank.setNext(paypal);
        paypal.setNext(bitcoin);

        // Let's try to pay using the first priority i.e. bank
        bank.pay(259);

        // Output will be
        // ==============
        // Cannot pay using bank. Proceeding ..
        // Cannot pay using paypal. Proceeding ..:
        // Paid 259 using Bitcoin!
    }
}
