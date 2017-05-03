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
        public NumericBadConsequence(String t, int l, int nVisible, int nHidden){
            super(t, l, nVisible, nHidden, new ArrayList(), new ArrayList(), false);
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
            BadConsequence bc = new NumericBadConsequence(text, levels, nVisibleTreasures, nHiddenTreasures);
            bc.specificHiddenTreasures = new ArrayList();
            bc.specificVisibleTreasures = new ArrayList();
            
            if(v.size() < bc.getNVisibleTreasures())
                bc.nVisibleTreasures = v.size();
            if(h.size() < bc.getNHiddenTreasures())
                bc.nHiddenTreasures = h.size();
            return bc;
        }
        @Override
        public String toString(){
            String cadena = text;
            if(levels != 0)
                cadena += " \nLevels_Down = " + Integer.toString(levels);
            if(nVisibleTreasures != 0 || nHiddenTreasures !=0)
                cadena += "\nRandom_Visible_Treasures_Down = " + Integer.toString(nVisibleTreasures) 
                + " / Random_Hidden_Treasures_Down = " + Integer.toString(nHiddenTreasures);
                
            return cadena;
        }
}
