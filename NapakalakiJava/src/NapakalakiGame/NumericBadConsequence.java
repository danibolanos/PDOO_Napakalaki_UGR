/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author danibolanos & jomabose
 */
public class NumericBadConsequence extends BadConsequence{
        private int nVisibleTreasures;
        private int nHiddenTreasures;
    
        public NumericBadConsequence(String t, int l, int nVisible, int nHidden){
            super(t, l);
            nVisibleTreasures = nVisible;
            nHiddenTreasures = nHidden;
        }
        
        public int getNVisibleTreasures(){
            return nVisibleTreasures;
        }
    
        public int getNHiddenTreasures(){
            return nHiddenTreasures;
        }
        
       @Override
       public boolean isEmpty(){
            boolean vacio=false;
            
            if (getNVisibleTreasures()==0 && getNHiddenTreasures()==0)
                vacio=true;
            
            return vacio;
       }
       
       @Override
        public void substractVisibleTreasure(Treasure t){
            if(getNVisibleTreasures()>0)
                nVisibleTreasures--;
        }
        
        @Override
        public void substractHiddenTreasure(Treasure t){
            if(getNHiddenTreasures()>0)
                nHiddenTreasures--;
        }
        
        @Override
        public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
            int nVisible = nVisibleTreasures;
            int nHidden = nHiddenTreasures;
            
            if(v.size() < nVisible)
                nVisible = v.size();
            
            if(h.size() < nHidden)
                nHidden = h.size();
            BadConsequence bc = new NumericBadConsequence(text, levels, nVisible, nHidden);
            
            return bc;
        }
        
        @Override
        public String toString(){
            String cadena = super.toString();
            cadena += "\nRandom_Visible_Treasures_Down = " + Integer.toString(nVisibleTreasures) 
            + " / Random_Hidden_Treasures_Down = " + Integer.toString(nHiddenTreasures);
                
            return cadena;
        }
}
