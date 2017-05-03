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
public class SpecificBadConsequence extends BadConsequence{
        public SpecificBadConsequence(String t, int l, ArrayList<TreasureKind> v,
        ArrayList<TreasureKind> h){
            super(t, l, 0, 0, v, h, false);
        }
       @Override
        public boolean isEmpty(){
            boolean vacio=false;
            if(getSpecificVisibleTreasures().isEmpty() && getSpecificHiddenTreasures().isEmpty())
                vacio = true;
            return vacio;
       }
       @Override
        public void substractVisibleTreasure(Treasure t){
            boolean quitado=false;
            TreasureKind tipo=t.getType();
            for(int i=0; i<getSpecificVisibleTreasures().size() && !quitado;i++){
                if(getSpecificVisibleTreasures().get(i)==tipo){
                    getSpecificVisibleTreasures().remove(i);
                    quitado=true;
                }
            }
        }
       @Override
        public void substractHiddenTreasure(Treasure t){
            boolean quitado=false;
            TreasureKind tipo=t.getType();
            for(int i=0; i<getSpecificHiddenTreasures().size() && !quitado;i++){
                if(getSpecificHiddenTreasures().get(i)==tipo){
                    getSpecificHiddenTreasures().remove(i);
                    quitado=true;
                }
            }
        }
        @Override
        public BadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
            BadConsequence bc = new SpecificBadConsequence(text, levels, specificVisibleTreasures, specificHiddenTreasures);
            bc.nHiddenTreasures = 0;
            bc.nVisibleTreasures = 0;

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
            
            return bc;
        }
        @Override
        public String toString(){
           String cadena = text; 
           
           if(levels != 0)
               cadena += " \nLevels_Down = " + Integer.toString(levels);

            cadena += "\nSpecific_Visible_Treasures_Down = " + getSpecificVisibleTreasures()
            + " / Specific_Hidden_Treasures_Down = " + getSpecificHiddenTreasures();
                
            return cadena;
        }
}
