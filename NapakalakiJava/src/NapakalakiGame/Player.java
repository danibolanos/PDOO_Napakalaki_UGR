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
public class Player {
    static final int MAXLEVEL = 10;
    
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    private Player enemy;
    private ArrayList<Treasure> visibleTreasures;
    private ArrayList<Treasure> hiddenTreasures;
    private BadConsequence pendingBadConsequence;
    
    private void bringToLife(){
        dead = false;
    }
    private int getCombatLevel(){
        int clevel = level;
        for(int i=0;i<visibleTreasures.size();i++)
            clevel+=visibleTreasures.get(i).getBonus();
        return clevel;
    }
    private void incrementLevels(int l){
        level+=l;
        if(level>MAXLEVEL)
            level=MAXLEVEL;
    }
    private void decrementLevels(int l){
        level-=l;
        if(level<1)
            level=1;
    }
    private void setPendingBadConsequence(BadConsequence b){
        pendingBadConsequence = b;
    }
    private void applyPrize(Monster m){
        //No se sabe
    }
    private void applyBadConsequence(Monster m){
        //No se sabe
    }
    private boolean canMakeTreasureVisible(Treasure t){
        //No se sabe
    }
    private int howManyVisibleTreasures(TreasureKind tKind){
        int cuantos=0;
        for(int i=0; i<visibleTreasures.size();++i)
            if(visibleTreasures.get(i).getType()==tKind)
                cuantos++;
        return cuantos;
    }
    private void dieIfNoTreasures(){
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
           dead = true;
    }
    private Treasure giveMeATreasure(){
        //No se sabe
    }
    private boolean canYouGiveMeATreasure(){
        boolean puedo=true;
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            puedo=false;
        return puedo;
        
    }
    private void haveStolen(){
        canISteal=false;
    }
    public Player(String name){
        this.name=name;
        level=1;
        dead=true;
        canISteal = true;
        visibleTreasures = new ArrayList();
        hiddenTreasures = new ArrayList();
        pendingBadConsequence = null;
        enemy = null;
    }
    public String getName(){
        return name;
    }
    public boolean isDead(){
        return dead;
    }
    public ArrayList<Treasure> getHiddenTreasures(){
        //No se sabe
    }
    public ArrayList<Treasure> getVisibleTreasures(){
        //No se sabe
    }
    public CombatResult combat(Monster m){
        //No se sabe
    }
    public void makeTreasureVisible(Treasure t){
        //No se sabe
    }
    public void discardVisibleTreasure(Treasure t){
        //No se sabe
    }
    public void discardHiddenTreasure(Treasure t){
        //No se sabe
    }
    public boolean validState(){
        boolean condicion = false;
        if (pendingBadConsequence.isEmpty() && hiddenTreasures.size()<5)
            condicion = true;
        return condicion;
    }
    public void initTreasures(){
        //No se sabe
    }
    public int getLevels(){
        return level;
    }
    public Treasure stealTreasure(){
        //No se sabe
    }
    public void setEnemy(Player enemy){
        this.enemy=enemy;
    }
    public boolean canISteal(){
        return canISteal;
    }
    public void discardAllTreasures(){
        //No se sabe
    }
    public String toString(){
        String cadena = "Nombre: " + name;
        cadena += "\nNivel: " + level;
        if(dead)
           cadena += "\nEstá muerto";
        else
            cadena += "\nEstá vivo";
        if(canISteal)
            cadena += "\nPuede robar";
        else
            cadena += "\nNo puede robar";
        cadena += "\nEnemigo: " + enemy;
        cadena += "\nTesoros visibles: " + visibleTreasures.toString();
        cadena += "\nTesoros ocultos: " + hiddenTreasures.toString();
        cadena += "\nMal rollo a cumplir: " + pendingBadConsequence.toString();
        
        return cadena;
    }
}
