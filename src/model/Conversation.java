/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.time.Instant;


/**
 *
 * @author Usuario
 */
public class Conversation {
    
    public String llmName;
    ArrayList<Message> messages;
    private long fechaIni;
    private long fechaFin;
     
    public Conversation(String llmName, ArrayList<Message> messages, long fechaIni, long fechaFin) {
        this.llmName = llmName;
        this.messages = messages;
        this.fechaIni = Instant.now().getEpochSecond();
        this.fechaFin = 
        
        
    }
    
    
}
