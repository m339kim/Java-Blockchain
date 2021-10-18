/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author minjaekim
 */
public class Transaction {
    String sender;
    String receiver;
    double amount;

    /**
     * 
     * @return 
     */
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * constructor
     * @param sender
     * @param receiver
     * @param amount 
     */
    public Transaction(String sender, String receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }
    
    public String getInformation() {
        return sender + " sent " + amount + " coins to " + receiver;
    }
    
}
