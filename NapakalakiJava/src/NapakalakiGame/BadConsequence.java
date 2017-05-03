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
    
    String text;
    int levels;
    int nVisibleTreasures;
    int nHiddenTreasures;
    boolean death;
    ArrayList<TreasureKind> specificVisibleTreasures;
    ArrayList<TreasureKind> specificHiddenTreasures;
    
    //Poner a visibilidad de paquete los atributos o hacer los setters correspondientes?
    
    public abstract boolean isEmpty();
    
    public int getLevels(){
        return levels;
    }
    
    public int getNVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    public ArrayList getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    public ArrayList getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    public abstract void substractVisibleTreasure(Treasure t);
    
    public abstract void substractHiddenTreasure(Treasure t);
    
    public BadConsequence(String t, int l, int nVisible, int nHidden,  ArrayList<TreasureKind> v,
        ArrayList<TreasureKind> h, boolean death){
        text = t;
        levels = l;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        this.death = death; 
        specificVisibleTreasures = new ArrayList();
        specificHiddenTreasures = new ArrayList();
    }
 
    public abstract BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h);
    
    public boolean getDeath(){
        return death;
    }

    public abstract String toString();
}