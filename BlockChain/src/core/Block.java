/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;

/**
 *
 * @author minjaekim
 */
public class Block {
    private int blockID;
    private String previousBlockHash; 
    private int nonce;
    private ArrayList<Transaction> transactionList;

    public int getBlockID() {
        return blockID;
    }

    public void setBlockID(int blockID) {
        this.blockID = blockID;
    }

    public String getPreviousBlockHash() {
        return previousBlockHash;
    }

    public void setPreviousBlockHash(String previousBlockHash) {
        this.previousBlockHash = previousBlockHash;
    }
    
    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    
    public Block(int blockID, String previousBlockHash, int nonce, ArrayList transactionList) {
        this.blockID = blockID;
        this.previousBlockHash = previousBlockHash;
        this.nonce = nonce;
        this.transactionList = transactionList;
    }
    
    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }
    
    public void getInformation() {
        System.out.println("----------------------------------------");
        System.out.println("Block ID: " + getBlockID());
        System.out.println("Previous Block HASH: " + getPreviousBlockHash());
        System.out.println("Nonce: " + getNonce());
        System.out.println("Number of Transactions: " + transactionList.size());
        for (int i=0; i < transactionList.size(); i++) {
            System.out.println(transactionList.get(i).getInformation());
        }
        System.out.println("Block HASH: " + getBlockHash());
        System.out.println("----------------------------------------");

    }
    
    public String getBlockHash() {
        String transactionInfos = "";
        for (int i = 0; i < transactionList.size(); i++) {
            transactionInfos += transactionList.get(i).getInformation();
        }
        return Util.getHash(nonce + transactionInfos + previousBlockHash);
    }
    
    public void mine() {
        while (true) {
            if (getBlockHash().substring(0, 4).equals("0000")) {
                System.out.println("Mining success in Block " + blockID);
                break;
            }
            nonce++;
        }
    }
}
