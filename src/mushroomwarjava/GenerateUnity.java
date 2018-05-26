/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mushroomwarjava;

import component.House;
import component.Unity;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan Germain
 */
public class GenerateUnity extends Thread {
    
    private House currentHouse;
    private boolean isRun;
    
    public GenerateUnity(House currentHouse) {
        this.currentHouse = currentHouse;
        this.isRun = true;
    }
    
    public void stopGenerate() {
        this.isRun = false;
    }
    
    @Override
    public void run() {
        while(this.isRun) {
            if(this.currentHouse.getCountUnitiesOfTheGame() < gameUI.MAX_UNITIES_SPAWNABLE) {
                this.currentHouse.addUnit(new Unity(this.currentHouse.getPlayer()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(House.class.getName()).log(Level.SEVERE, null, ex);
                }                
            }
        }
    }
    
}
