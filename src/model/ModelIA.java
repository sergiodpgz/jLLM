/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Usuario
 */
public class ModelIA implements ILLM, IRepository {
    
    /**
     * 
     * Aquí guardamos la información del estado de la aplicación, será donde
     * guardemos las diferentes conversaciones que el usuario vaya introduciendo
     * 
     * @return
     */
    private ArrayList<Conversation> conversations;
    // Implementamos un objeto repository que implementa la interfaz IRepository el usuario nos indica el tipo de repositorio
    private IRepository repository;
    // Tipo de ILLM seleccionado por el usuario
    private ILLM illm;
    
    public ModelIA (IRepository repository, ILLM illm) {
        this.repository = repository;
        this.illm = illm;
        conversations = new ArrayList<>();
        
    }
    
    /**
     * *
     *
     * Permite exportar las conversaciones empleando el repository cargado.
     *
     * @return
     */
    public boolean exportConversations() {
        return repository.exportarAlum nos(alumnos);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
