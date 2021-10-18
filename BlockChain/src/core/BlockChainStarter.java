/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author minjaekim
 */
public class BlockChainStarter {
    
    public static void main(String[] args) {
        
        // PoW (Proof of Work) implementation
        System.out.println("=====Proof of Work======================");
        /**
         * Test: string->SHA256->HASH
         */
        System.out.println(Util.getHash("myname"));
        
        /**
         * Proof of Work (mining)
         */
        int nonce = 0; // counter
        while (true) {
            // change some number, nonce, to HASH, then check if the first
            //   six letters equal 000000 (success).
            if (Util.getHash(nonce + "").substring(0,6).equals("000000")) {
                System.out.println("Answer: " + nonce);
                System.out.println("HASH: " + Util.getHash(nonce + ""));
                break;
            }
            nonce++;
        }

        
        // Bitcoin transaction simulation implementation
        System.out.println("\n\n=====Bitcoin Transaction Simulation=====");
        
        Block prevBlock = null;
        int numBlocks;
        int numTransactions;
        int blockNum = 1;
        int transNum = 1;
        
        ArrayList<Block> alBlocks = new ArrayList<>();
        
        String sender, receiver;
        double numCoins;
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter number of blocks to create: ");
        numBlocks = input.nextInt();
        
        System.out.print("Enter the maximum number of transactions to make per block: ");
        numTransactions = input.nextInt();
        final int myNumTransactions = numTransactions;
        
        while (numBlocks > 0) {
            System.out.print("\nThis is Block #" + blockNum + ".\n");
            
            Block block;
            
            if (prevBlock == null) {
                block = new Block(blockNum, null, 0, new ArrayList());
            } else {
                block = new Block(blockNum, 
                                    prevBlock.getBlockHash(), 
                                    0, 
                                    new ArrayList());
            }
            
            while (numTransactions > 0) {
                System.out.println("\nTransaction #" + transNum + ":");
                System.out.print("   Sender name (e to exit): ");
                sender = input.next();
                if ("e".equals(sender)) break;
                System.out.print("   Receiver name (e to exit): ");
                receiver = input.next();
                if ("e".equals(receiver)) break;
                System.out.print("   Number of coins to send (-1 to exit): ");
                numCoins = input.nextDouble();
                if (numCoins == -1) break;
                block.addTransaction(new Transaction(sender, receiver, numCoins));
                numTransactions--;
                transNum++;
            }
            System.out.println("----------------------------------------");
            block.mine();
            alBlocks.add(block);
            block.getInformation();
            
            // reset/ update values
            transNum = 1;
            numTransactions = myNumTransactions;
            prevBlock = block;
            numBlocks--;
            blockNum++;
        }
        
        String yn;
        System.out.print("Print all blocks? ((y)es or (n)o): ");
        yn = input.next();
        
        if (yn.equals("y")) {
            for (int i = 0; i < alBlocks.size(); i++) {
                alBlocks.get(i).getInformation();
            }
        }
    }
}