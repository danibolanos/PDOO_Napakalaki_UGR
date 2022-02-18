/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author danibolanos & jomabose
 */
public class DeathBadConsequence extends NumericBadConsequence {
    public DeathBadConsequence(String t){
        super(t, Player.MAXLEVEL, MAXTREASURES, MAXTREASURES);
    }
    
    @Override
    public String toString(){
        String cadena = super.toString();
        cadena += "\nDeath = " + Boolean.toString(true);
        
        return cadena;
    }
    
    @Override
    public String getInfo(){
        String cadena = super.getInfo();
        cadena += "\nMuerte = " + Boolean.toString(true);
        
        return cadena;
    }
}
