/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.*;

/**
 *
 * @author danibolanos
 */

public class BadConsequence {
    
    static final int MAXTREASURES = 10;
    
    private String text;
    private int levels;
    private int nVisibleTreasures;
    private int nHiddenTreasures;
    private boolean death;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    private ArrayList<TreasureKind> specificHiddenTreasures;
    
    public boolean isEmpty(){
       boolean vacio=false;
       if (nVisibleTreasures==0 && nHiddenTreasures==0 && specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty())
           vacio=true;
       return vacio;
    }
    
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
    
    public void substractVisibleTreasure(Treasure t){
        //No se sabe todavía
    }
    
    public void substractHiddenTreasure(Treasure t){
        //No se sabe todavía
    }
    
    public BadConsequence(String t, int l, int nVisible, int nHidden){
        text = t;
        levels = l;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        death = false; 
        specificVisibleTreasures = new ArrayList();
        specificHiddenTreasures = new ArrayList();
    }
    
    public BadConsequence(String t, int l, ArrayList<TreasureKind> v,
        ArrayList<TreasureKind> h){
        text = t;
        levels = l;
        specificVisibleTreasures = v;
        specificHiddenTreasures = h;
        death = false;
        //-1 Indica que el mal rollo afecta solo a tesoros específicos
        nVisibleTreasures = -1;
        nHiddenTreasures = -1;
    }
    
    public BadConsequence(String t, boolean death){
        text = t;
        this.death = death;     
        levels = Player.MAXLEVEL;
        nVisibleTreasures = BadConsequence.MAXTREASURES;
        nHiddenTreasures = BadConsequence.MAXTREASURES;
        specificVisibleTreasures = new ArrayList();
        specificHiddenTreasures = new ArrayList();
    }
 
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
      //No se sabe todavía
    }
    
    //NO UML
    
    public boolean getDeath(){
        return death;
    }

    public String toString(){
        String cadena = text; 
           if(death)
               cadena += "\nDeath = " + death;
           else{
           if(levels != 0)
               cadena += " \nLevels_Down = " + Integer.toString(levels);
           if(nVisibleTreasures != -1 && (nVisibleTreasures != 0 || nHiddenTreasures !=0))
               cadena += "\nRandom_Visible_Treasures_Down = " + Integer.toString(nVisibleTreasures) 
               + " / Random_Hidden_Treasures_Down = " + Integer.toString(nHiddenTreasures);
           if(nVisibleTreasures == -1)
               cadena += "\nSpecific_Visible_Treasures_Down = " + getSpecificVisibleTreasures()
               + " / Specific_Hidden_Treasures_Down = " + getSpecificHiddenTreasures();
           }
        return cadena;
    }
}