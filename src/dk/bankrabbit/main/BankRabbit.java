/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.bankrabbit.main;

import dk.bankrabbit.controller.CalculateQuote;
import java.io.IOException;

/**
 *
 * @author marekrigan
 */
public class BankRabbit {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.lang.InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException 
    {
        CalculateQuote.receiveMessages();
    }
    
}
