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
public class ModelIA {
    
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
    File ficheroEstadoSerializado;
    
    public ModelIA (IRepository repository, ILLM illm) {
        this.repository = repository;
        this.illm = illm;
        ficheroEstadoSerializado = Paths.get(System.getProperty("user.home"), "Desktop", "jLLM.bin").toFile();
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
        return repository.exportConversation(conversations);
    }
    
    public boolean importConversations() {
       
        ArrayList<Conversation> conversacionesImportadas = repository.importConversations();
        
        
        
        
        
        
    }
    
    /**
     * 
     * Función de carga del estado previo de la aplicación
     * 
     * @return
     */
    
    public boolean cargarEstadoAplicación() {

        if (ficheroEstadoSerializado.exists() && ficheroEstadoSerializado.isFile()) {
            ObjectInputStream ois = null;
            try {
                ois = new ObjectInputStream(new FileInputStream(ficheroEstadoSerializado));
                this.conversations = (ArrayList<Conversation>) ois.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                // Dejamos el error para la depuración, por el canal err.
                System.err.println("Error durante la deserialización: " + ex.getMessage());
                return false;
            } finally {
                if (ois != null) {
                    try {
                        ois.close();
                    } catch (IOException ex) {
                        // Dejamos el error para la depuración, por el canal err.
                        System.err.println("Error durante la deserialización: " + ex.getMessage());
                        return false;
                    }
                }
            }
            return true;
        } else {
            return false;
        }

    }
    
    /**
     * 
     * Función de guardado del estado previo de la aplicación
     * 
     * @return
     */

    public boolean guardarEstadoAplicación() {

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(ficheroEstadoSerializado));
            oos.writeObject(conversations);
            return true;
        } catch (IOException ex) {
            // Dejamos el error para la depuración, por el canal err.
            System.err.println("Error durante la serialización: " + ex.getMessage());
            return false;
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    // Dejamos el error para la depuración, por el canal err.
                    System.err.println("Error al cerrar el flujo: " + ex.getMessage());
                    return false;
                }
            }
        }

    }
    
    /**
     * 
     * GETTERS Y SETTERS
     * 
     * @return
     */
    
    public ArrayList<Conversation> getConversations() {
        return conversations;
    }

    public void setConversations(ArrayList<Conversation> conversations) {
        this.conversations = conversations;
    }

    public IRepository getRepository() {
        return repository;
    }

    public void setRepository(IRepository repository) {
        this.repository = repository;
    }

    public ILLM getIllm() {
        return illm;
    }

    public void setIllm(ILLM illm) {
        this.illm = illm;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
