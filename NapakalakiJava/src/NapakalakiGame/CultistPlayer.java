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
    protected int getCombatLevel(){
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
    //@Override
    private Treasure giveMeATreasure(){
        int indice=(int) (Math.random()*(super.getVisibleTreasures()).size()-1);
        Treasure tesoro=super.getVisibleTreasures().get(indice);
        super.getVisibleTreasures().remove(indice);
        return tesoro;        
    }
    //@Override
    private boolean canYouGiveMeATreasure(){
        boolean puedo=true;
        if((super.getVisibleTreasures()).isEmpty())
            puedo=false;
        return puedo;       
    }
    public static int getTotalCultistPlayers(){
        return totalCultistPlayers;
    }
}
