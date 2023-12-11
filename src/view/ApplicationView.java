/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import controller.ControllerIA;

/**
 *
 * @author Usuario
 */
public abstract class ApplicationView {
    
    protected ControllerIA c;

    public abstract void showApplicationStart(String msgWelcome);
    
    public abstract void showMainMenu();
    
    public abstract void showApplicationEnd(String msgGoodbye);

    public void setController(ControllerIA c) {
        this.c = c;
    }
    
}
