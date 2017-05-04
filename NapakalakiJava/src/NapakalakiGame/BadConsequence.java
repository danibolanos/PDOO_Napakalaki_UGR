/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.*;

/**
 *
 * @author danibolanos & jomabose
 */

public abstract class BadConsequence {
    
    static final int MAXTREASURES = 10;
    
    protected String text;
    protected int levels;
    protected boolean death;
    
    //Poner a visibilidad de paquete los atributos o hacer los setters correspondientes?
    
    public abstract boolean isEmpty();
    
    public int getLevels(){
        return levels;
    }
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    public BadConsequence(String t, int l){
        text = t;
        levels = l;
    }
 
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
    
    public boolean getDeath(){
        return false;
    }

    public String toString(){
        String cadena = text;
        if(levels != 0)
            cadena += " \nLevels_Down = " + Integer.toString(levels);
        return cadena;
    }
}