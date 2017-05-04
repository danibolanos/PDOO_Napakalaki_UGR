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
        private ArrayList<TreasureKind> specificVisibleTreasures;
        private ArrayList<TreasureKind> specificHiddenTreasures;
    
        public SpecificBadConsequence(String t, int l, ArrayList<TreasureKind> v,
        ArrayList<TreasureKind> h){
            super(t, l);
            specificVisibleTreasures = v;
            specificHiddenTreasures = h;
        }
        public ArrayList getSpecificHiddenTreasures(){
            return specificHiddenTreasures;
        }
    
        public ArrayList getSpecificVisibleTreasures(){
            return specificVisibleTreasures;
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
            ArrayList<TreasureKind> visible = new ArrayList();
            ArrayList<TreasureKind> specificVisible = new ArrayList(specificVisibleTreasures);
            for(Treasure t:v){
                TreasureKind tipo = t.getType();
                boolean fin=false;
                for(int i=0; i<specificVisible.size() && !fin; i++)
                    if(specificVisible.get(i)==tipo){
                        visible.add(specificVisible.get(i));
                        specificVisible.remove(i);
                        fin = true;
                    }
            }
            ArrayList<TreasureKind> hidden = new ArrayList();
            ArrayList<TreasureKind> specificHidden = new ArrayList();
            for(Treasure t:h){
                TreasureKind tipo = t.getType();
                boolean fin=false;
                for(int i=0; i<specificHidden.size() && !fin; i++)
                    if(specificHidden.get(i)==tipo){
                        hidden.add(specificHidden.get(i));
                        specificHidden.remove(i);
                        fin = true;
                    }
            }
            specificVisible= visible;
            specificHidden = hidden;
            BadConsequence bc = new SpecificBadConsequence(text, levels, specificVisible, specificHidden);
            return bc;
        }
        @Override
        public String toString(){
           String cadena = super.toString();
           cadena += "\nSpecific_Visible_Treasures_Down = " + getSpecificVisibleTreasures()
           + " / Specific_Hidden_Treasures_Down = " + getSpecificHiddenTreasures();
     
           return cadena;
        }
}
