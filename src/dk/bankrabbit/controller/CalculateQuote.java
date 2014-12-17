/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.bankrabbit.controller;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import dk.bankrabbit.dto.LoanRequestDTO;
import dk.bankrabbit.dto.LoanResponseDTO;
import dk.bankrabbit.messaging.Receive;
import dk.bankrabbit.messaging.Send;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author marekrigan
 */
public class CalculateQuote 
{
    private static Gson gson;
    
    public static void receiveMessages() throws IOException,InterruptedException
    {
        gson = new Gson();
        
        HashMap<String,Object> objects = Receive.setUpReceiver();
        
        QueueingConsumer consumer = (QueueingConsumer) objects.get("consumer");
        Channel channel = (Channel) objects.get("channel");
        
        LoanRequestDTO loanRequestDTO;
        LoanResponseDTO loanResponseDTO;
        
        while (true) 
        {
          QueueingConsumer.Delivery delivery = consumer.nextDelivery();
          String message = new String(delivery.getBody());
          
          loanRequestDTO = gson.fromJson(message, LoanRequestDTO.class);
          
          double interestRate = new Random().nextDouble()*20;
          
          loanResponseDTO = new LoanResponseDTO(interestRate, loanRequestDTO.getSsn());
          
          sendMessage(loanResponseDTO);

          channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }
        
    }
    
    public static void sendMessage(LoanResponseDTO dto) throws IOException
    {
        String message = gson.toJson(dto);
        
        Send.sendMessage(message);
    }
}
