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

public class Monster {
    private String name;
    private int combatLevel;
    private Prize prize;
    private BadConsequence badConsequence;
    
    public Monster(String n, int l, BadConsequence b, Prize p){
        name = n;
        combatLevel = l;
        badConsequence = b;
        prize = p;
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
    
    //NO UML
    
    public Prize getPrize(){
        return prize;
    }
    
    public String toString(){
        return "Name : " + name + "\nCombat_Level : " + Integer.toString(combatLevel) 
        + "\nPrize : " + prize.toString() + "\nBad_Consequence : " 
        + badConsequence.toString();
    }
}
