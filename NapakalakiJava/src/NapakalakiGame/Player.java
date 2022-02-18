/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.*;
import GUI.Dice;

/**
 *
 * @author danibolanos & jomabose
 */
public class Player {
    static final int MAXLEVEL = 10;
    
    private String name;
    private int level;
    private boolean dead;
    private boolean canISteal;
    protected Player enemy;
    private ArrayList<Treasure> visibleTreasures;
    private ArrayList<Treasure> hiddenTreasures;
    private BadConsequence pendingBadConsequence;
    
    public Player(String name){
        this.name=name;
        level=1;
        dead=true;
        canISteal = true;
        visibleTreasures = new ArrayList();
        hiddenTreasures = new ArrayList();
        //enemy
        //pendingBadConsequence
    }
    
    public Player(Player p){
        this.name = p.name;
        this.level = p.level;
        this.dead = p.dead;
        this.canISteal = p.canISteal;
        this.enemy = p.enemy;
        this.visibleTreasures = p.visibleTreasures;
        this.hiddenTreasures = p.hiddenTreasures;
        this.pendingBadConsequence = p.pendingBadConsequence;
    }    
    
    protected int getOponentLevel(Monster m){
        return m.getCombatLevel();
    }
    
    protected boolean shouldConvert(){
        Dice dice = Dice.getInstance();
        int number = dice.nextNumber();
        boolean sectario = false;
        
        if (number == 6)
            sectario = true;
        
        return sectario;            
    }
    
    public int getCombatLevel(){
        int clevel = level;
        
        for(int i=0;i<visibleTreasures.size();i++)
            clevel+=visibleTreasures.get(i).getBonus();
        
        return clevel;
    }  
    
    private void bringToLife(){
        dead = false;
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
        int nLevels = m.getLevelsGained();
        incrementLevels(nLevels);
        int nTreasures = m.getTreasuresGained();
        
        if(nTreasures>0){
            CardDealer dealer=CardDealer.getInstance();
            
            for(int i=0; i<nTreasures; i++){
                Treasure treasure = dealer.nextTreasure();
                hiddenTreasures.add(treasure);
            }
        }
    }
    
    private void applyBadConsequence(Monster m){
        BadConsequence badConsequence = m.getBadConsequence();
        int nLevels = badConsequence.getLevels();
        decrementLevels(nLevels);
        BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(visibleTreasures, hiddenTreasures);
        setPendingBadConsequence(pendingBad);
    }
    
    private boolean canMakeTreasureVisible(Treasure t){
        boolean puede = false;
        int numVisiblesTipo=0;
        TreasureKind tipo=t.getType();
        
        if(tipo==TreasureKind.BOTHHANDS){
            
            for(Treasure tesoro:visibleTreasures){
                
                if(tesoro.getType()==tipo | tesoro.getType()==TreasureKind.ONEHAND)
                    numVisiblesTipo++;
            }
        }
        
        else{
           
            if(tipo==TreasureKind.ONEHAND){
               
                for(Treasure tesoro:visibleTreasures){
                 
                    if(tesoro.getType()==tipo)
                        numVisiblesTipo++;
                  
                    if(tesoro.getType()==TreasureKind.BOTHHANDS)
                        numVisiblesTipo+=2;
                }
            }
            
            else{
                
                for(Treasure tesoro:visibleTreasures){
                   
                    if(tesoro.getType()==tipo)
                        numVisiblesTipo++;
                }
            }
        }
        
        if(tipo==TreasureKind.BOTHHANDS && numVisiblesTipo==0)
            puede=true;
        
        else{
            
            if(tipo==TreasureKind.ONEHAND && numVisiblesTipo<2)
                puede=true;
            
            else
                
                if(numVisiblesTipo==0)
                    puede=true;
        }
        
        return puede;
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
    
    protected Treasure giveMeATreasure(){
        int indice=(int) (Math.random()*hiddenTreasures.size()-1);
        Treasure tesoro = hiddenTreasures.get(indice);
        hiddenTreasures.remove(indice);
        
        return tesoro;
    }
    
    protected boolean canYouGiveMeATreasure(){
        boolean puedo=true;
        
        if(hiddenTreasures.isEmpty())
            puedo=false;
        
        return puedo;
    }
    
    private void haveStolen(){
        canISteal=false;
    }
    
    public String getName(){
        return name;
    }
    
    public boolean isDead(){
        return dead;
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        return hiddenTreasures;
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        return visibleTreasures;
    }
    
    public CombatResult combat(Monster m){
        CombatResult combatResult;
        int myLevel = getCombatLevel();
        int monsterLevel = getOponentLevel(m);
        
        if(!canISteal){
           Dice dice = Dice.getInstance();
           int number = dice.nextNumber();
           
           if(number<3){
               monsterLevel += enemy.getCombatLevel();
           }
        }
        
        if(myLevel>monsterLevel){
            applyPrize(m);
            
            if(level >= MAXLEVEL)
                combatResult = CombatResult.WINGAME;
            
            else
                combatResult = CombatResult.WIN;  
        }
        
        else{
            applyBadConsequence(m);
            combatResult = CombatResult.LOSE;
            
            if (shouldConvert())
                combatResult = CombatResult.LOSEANDCONVERT;
        }
        
        return combatResult;
    }
    
    public void makeTreasureVisible(Treasure t){
        boolean canI = canMakeTreasureVisible(t);
        
        if(canI){
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
        }
    }
    
    public void discardVisibleTreasure(Treasure t){
        visibleTreasures.remove(t);
        
        if((pendingBadConsequence!=null)&&(!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractVisibleTreasure(t);
        dieIfNoTreasures();
    }
    
    public void discardHiddenTreasure(Treasure t){
        hiddenTreasures.remove(t);
        
        if((pendingBadConsequence!=null)&&(!pendingBadConsequence.isEmpty()))
            pendingBadConsequence.substractHiddenTreasure(t);
        dieIfNoTreasures();
    }
    
    public boolean validState(){
        boolean condicion = false;
        
        if ((pendingBadConsequence==null || pendingBadConsequence.isEmpty()) && hiddenTreasures.size()<5)
            condicion = true;
        
        return condicion;
    }
    
    public void initTreasures(){
        CardDealer dealer = CardDealer.getInstance();
        Dice dice = Dice.getInstance();
        bringToLife();
        Treasure treasure = dealer.nextTreasure();
        hiddenTreasures.add(treasure);
        int number = dice.nextNumber();
        
        if(number > 1){
            Treasure t = dealer.nextTreasure();
            hiddenTreasures.add(t);
        }
        
        if(number == 6){
            Treasure t = dealer.nextTreasure();
            hiddenTreasures.add(t);
        }
    }
    
    public int getLevels(){
        return level;
    }
    
    public Player getEnemy(){
        return enemy;
    }
    
    public Treasure stealTreasure(){
        boolean canI = canISteal();
        Treasure treasure = null;
        
        if(canI){
            boolean canYou = enemy.canYouGiveMeATreasure();
            
            if(canYou){
                treasure = enemy.giveMeATreasure();
                hiddenTreasures.add(treasure);
                haveStolen();
            }
        }
        
        return treasure;
    }
    
    public void setEnemy(Player enemy){
        this.enemy=enemy;
    }
    
    public boolean canISteal(){
        return canISteal;
    }
    
    public void discardAllTreasures(){
        ArrayList<Treasure> copyVisible = new ArrayList(visibleTreasures);
        ArrayList<Treasure> copyHidden = new ArrayList(hiddenTreasures);
        
        for(Treasure treasure:copyVisible){
            discardVisibleTreasure(treasure);
        }
        
        for(Treasure treasure:copyHidden){
            discardHiddenTreasure(treasure);
        }
    }
    
    public BadConsequence getPendingBadConsequence(){
        return pendingBadConsequence;
    }
    
    public String toString(){
        String cadena = "Nombre: " + name;
        cadena += "\nNivel: " + level;
        cadena += "\nNivel de Combate: " + getCombatLevel();
        
        if(dead)
           cadena += "\nEstá muerto";
        
        else{
            cadena += "\nEstá vivo";
        
        if(canISteal)
            cadena += "\nPuede robar";
        
        else
            cadena += "\nNo puede robar";
        cadena += "\nEnemigo: ";
        
        if (enemy != null)
           cadena += enemy.getName();
        
        cadena += "\n\nTesoros visibles: \n" + visibleTreasures.toString();
        cadena += "\n\nTesoros ocultos: \n" + hiddenTreasures.toString() + "\n";
        cadena += "\nMal rollo a cumplir: ";
        }
        
        if (pendingBadConsequence != null)
           cadena += pendingBadConsequence.toString();
        
        return cadena;
    }
}
