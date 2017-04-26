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
       if (nVisibleTreasures==-1){
           if(specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty())
               vacio = true;
       }
       else
           if (nVisibleTreasures==0 && nHiddenTreasures==0)
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
        if(nVisibleTreasures==-1){
           boolean quitado=false;
           TreasureKind tipo=t.getType();
           for(int i=0; i<specificVisibleTreasures.size() && !quitado;i++){
              if(specificVisibleTreasures.get(i)==tipo){
                 specificVisibleTreasures.remove(i);
                 quitado=true;
              }
           }
        }
        else
            if(nVisibleTreasures>0)
                nVisibleTreasures--;
    }
    
    public void substractHiddenTreasure(Treasure t){
        if(nHiddenTreasures==-1){
           boolean quitado=false;
           TreasureKind tipo=t.getType();
           for(int i=0; i<specificHiddenTreasures.size() && !quitado;i++){
              if(specificHiddenTreasures.get(i)==tipo){
                specificHiddenTreasures.remove(i);
                quitado=true;
              }
           }
        }
        else
            if(nHiddenTreasures>0)
                nHiddenTreasures--;
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
        nVisibleTreasures = MAXTREASURES;
        nHiddenTreasures = MAXTREASURES;
        specificVisibleTreasures = new ArrayList();
        specificHiddenTreasures = new ArrayList();
    }
 
    public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        //Quizas no sea lo mas correcto, porque no deberia modificar el mal rollo, sino 
        //devolver otro distinto
        BadConsequence bc = new BadConsequence(this.text,false);
        bc.levels = this.levels;
        bc.nHiddenTreasures = this.nHiddenTreasures;
        bc.nVisibleTreasures = this.nVisibleTreasures;
        bc.specificHiddenTreasures = this.specificHiddenTreasures;
        bc.specificVisibleTreasures = this.specificVisibleTreasures;
        if(nVisibleTreasures==-1){
            ArrayList<TreasureKind> visible = new ArrayList();
            for(Treasure t:v){
                TreasureKind tipo = t.getType();
                boolean fin=false;
                for(int i=0; i<bc.specificVisibleTreasures.size() && !fin; i++)
                    if(bc.specificVisibleTreasures.get(i)==tipo){
                        visible.add(bc.specificVisibleTreasures.get(i));
                        bc.specificVisibleTreasures.remove(i);
                        fin = true;
                    }
            }
            ArrayList<TreasureKind> hidden = new ArrayList();
            for(Treasure t:h){
                TreasureKind tipo = t.getType();
                boolean fin=false;
                for(int i=0; i<bc.specificHiddenTreasures.size() && !fin; i++)
                    if(bc.specificHiddenTreasures.get(i)==tipo){
                        hidden.add(bc.specificHiddenTreasures.get(i));
                        bc.specificHiddenTreasures.remove(i);
                        fin = true;
                    }
            }
            bc.specificVisibleTreasures = visible;
            bc.specificHiddenTreasures = hidden;
        }
        else{
            if(v.size() < bc.getNVisibleTreasures())
                bc.nVisibleTreasures = v.size();
            if(h.size() < bc.getNHiddenTreasures())
                bc.nHiddenTreasures = h.size();
        }
        return bc;
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