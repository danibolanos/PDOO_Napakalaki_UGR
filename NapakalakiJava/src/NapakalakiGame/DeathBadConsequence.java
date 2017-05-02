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
    public DeathBadConsequence(String t, boolean death){
        super(t, Player.MAXLEVEL, MAXTREASURES, MAXTREASURES);
    }
}
