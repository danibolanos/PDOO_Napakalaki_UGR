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

public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badConsequence;
    private int levelChangeAgainstCultistPlayer = 0;
    
    public Monster(String n, int l, BadConsequence b, Prize p){
        name = n;
        combatLevel = l;
        badConsequence = b;
        prize = p;
    }
    
    public Monster(String n, int l, BadConsequence badConsequence, Prize p, int lC){
        name = n;
        combatLevel = l;
        this.badConsequence = badConsequence;
        prize = p;
        levelChangeAgainstCultistPlayer = lC;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    public BadConsequence getBadConsequence(){
        return badConsequence;
    }
    
    public int getLevelsGained(){
        return prize.getLevels();
    }
    
    public int getTreasuresGained(){
        return prize.getTreasures();
    }
    
    public Prize getPrize(){
        return prize;
    }
    
    public int getCombatLevelAgainstCultistPlayer(){
        return getCombatLevel()+levelChangeAgainstCultistPlayer;
    }
    
    public String toString(){
        String cadena = "Name : " + name + "\nCombat_Level : " + Integer.toString(combatLevel) 
        + "\nPrize : " + prize.toString() + "\nBad_Consequence : " 
        + badConsequence.toString();
        if (levelChangeAgainstCultistPlayer != 0){
            if (levelChangeAgainstCultistPlayer > 0)
              cadena += "\n+" + levelChangeAgainstCultistPlayer + " contra Sectarios";
            else
              cadena += "\n" + levelChangeAgainstCultistPlayer + " contra Sectarios";
        }
        return cadena;
    }
}
