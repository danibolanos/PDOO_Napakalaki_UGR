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
        death = true;
    }
    @Override
    public String toString(){
        String cadena = text;
        cadena += "\nDeath = " + death;
        return cadena;
    }
}
