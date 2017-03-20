/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.*;
/**
 *
 * @author jomabose
 */
public class Napakalaki {
    
    private static final Napakalaki instance = new Napakalaki();
    
    private Monster currentMonster;
    private CardDealer dealer;
    private Player currentPlayer;
    private ArrayList<Player> players;
    
    private Napakalaki() {
        //currentMonster
        //dealer
        //currentPlayer
        players = new ArrayList();
    }
    private void initPlayers(String[] name){
        //No se sabe
    }
    private Player nextPlayer(){
        //No se sabe
    }
    private boolean nextTurnAllowed(){
        //No se sabe
    }
    private void setEnemies(){
        //No se sabe
    }
    
    public static Napakalaki getInstance() {
        return instance;
    }
    public CombatResult developCombat(){
        //No se sabe
    }
    public void discardVisibleTreasures(Treasure[] treasures){
        //No se sabe
    }
    public void discardHiddenTreasures(Treasure[] treasures){
        //No se sabe
    }
    public void makeTreasuresVisible(Treasure[] treasures){
        //No se sabe
    }
    public void initGame(String[] players){
        //No se sabe
    }
    public Player getCurrentPlayer(){
        //No se sabe
    }
    public Monster getCurrentMonster(){
        //No se sabe
    }
    public boolean nextTurn(){
        //No se sabe
    }
    public boolean endOfGame(CombatResult result){
        //No se sabe
    }
    public String toString(){
        String cadena = "Monstruo actual: " + currentMonster.toString();
        cadena += "\nJugador actual: " + currentPlayer.toString();
        
        cadena += "\nTodos los jugadores: ";
        for(int i=0; i<players.size(); i++)
            cadena += "\n" + players.get(i).toString();
        cadena += "\nBaraja: " + dealer.toString();
        
        return cadena;
    }
}
