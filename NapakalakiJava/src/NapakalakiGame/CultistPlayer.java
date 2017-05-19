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
public class CultistPlayer extends Player{
    private static int totalCultistPlayers=0;
    Cultist myCultistCard;
    
    public CultistPlayer(Player p, Cultist c){
       super(p);
       myCultistCard = c;
       totalCultistPlayers++;
    }
    @Override
    public int getCombatLevel(){
        int levelPlayerAdded = (int) (super.getCombatLevel()*0.7);
        int combatLevel = super.getCombatLevel() + levelPlayerAdded + 
        myCultistCard.getGainedLevels()*totalCultistPlayers;
        
        return combatLevel;
    }
    @Override
    protected int getOponentLevel(Monster m){
        return m.getCombatLevelAgainstCultistPlayer();
    }
    @Override
    protected boolean shouldConvert(){
        return false;
    }
    @Override
    protected Treasure giveMeATreasure(){
        int indice=(int) (Math.random()*getVisibleTreasures().size()-1);
        Treasure tesoro = getVisibleTreasures().get(indice);
        getVisibleTreasures().remove(indice);
        
        return tesoro;        
    }
    @Override
    protected boolean canYouGiveMeATreasure(){
        boolean puedo=true;
        
        if(getVisibleTreasures().isEmpty())
            puedo=false;
        
        return puedo;       
    }
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
    @Override
    public String toString(){
        String cadena = super.toString();
        cadena += "\n\n" + "*" + this.getName()+" es Sectario*";
        
        return cadena;
    }
}
