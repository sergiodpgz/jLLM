/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jllm;
import controller.ControllerIA;
import model.ModelIA;
import model.IRepository;
import view.ApplicationView;
import model.ILLM;
import view.SimpleConsoleView;

/**
 *
 * @author Usuario
 */
public class JLLM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IRepository repository;
        ApplicationView view;
        ILLM illm;
        
        
        /**
         * 
         * LLamada esperada java -jar jLLM.jar repository model vista
         * @return
         * OPCIONES repository
         * - xml
         * - json
         * OPCIONES model
         * - fake
         * -csv
         * OPCIONES vista
         * -En principio la opción por defecto y la única consola
         */
        
        if(args.length == 3) { 
            repository = getRepositoryForOption(args[0]);
            illm = getIllmForOption(args[1]);
            view = getViewForOption(args[2]);
        } else {
            repository = new JSONRepository();
            illm = new RandomCSVLLM();
            view = new SimpleConsoleView(); 
        }
        
        ModelIA model = new ModelIA(repository, illm);
        ControllerIA c = new ControllerIA(model, view);
    
        c.initApplication();  
    }
    
    /**
     * getRepositoryForOption devolverá el tipo de serialización que nosotros indiquemos que queremos 
     */
    
    private static IRepository getRepositoryForOption(String argument) {
        switch (argument) {
            case "xml":
                return new XMLRepository();
            case "json":
                return new JSONRepository();
            default:
                return new JSONRepository();
        }
    }
    
    /**
     * getViewForOption devolverá la vista correspondiente al parámetro que le indiquemos 
     */
    
    private static ApplicationView getViewForOption(String argument) { 
        switch (argument) {
            case "console":
                return new SimpleConsoleView();        
            default:
                return new SimpleConsoleView();
        }
    }
    
    private static ILLM getIllmForOption(String argument) {
        switch(argument) {
            case "fake":
                return new FakeLLM();
            case "csv":
                return new RandomCSVLLM();
            default:
                return new RandomCSVLLM();
        }
        
    
    }
    
}
