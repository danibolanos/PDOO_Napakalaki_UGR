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
        currentPlayer = null;
        players = new ArrayList();
    }
    private void initPlayers(ArrayList<String> name){
        for(int i=0; i < name.size(); ++i)
           players.add(new Player(name.get(i)));
    }
    private Player nextPlayer(){
        int indice;
        if (currentPlayer == null){
           indice = (int) (Math.random()*players.size());
           currentPlayer = players.get(indice);
        }
        else{
            indice = players.indexOf(currentPlayer)+1;
            if(indice==players.size())
                currentPlayer = players.get(0);
            else
                currentPlayer = players.get(indice);
        }
        return currentPlayer;
    }
    private boolean nextTurnAllowed(){
        boolean permitido;
        
        if (currentPlayer == null)
            permitido = true;
        else{
            if(currentPlayer.validState())
                permitido = true;
            permitido = false;
        }
        
        return permitido;
    }
    private void setEnemies(){
        int indice;
        for(int i=0; i<players.size(); i++){
            indice = (int) (Math.random()*players.size()-1);
            if(indice==i)
                indice = players.size()-1;
            players.get(i).setEnemy(players.get(indice));
        }
    }
    
    public static Napakalaki getInstance() {
        return instance;
    }
    public CombatResult developCombat(){
        //No se sabe
    }
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
        for(Treasure treasure:treasures){
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        for(Treasure treasure:treasures){
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    public void makeTreasuresVisible(ArrayList<Treasure> treasures){
        //No se sabe
    }
    public void initGame(ArrayList<String> players){
        initPlayers(players);
        setEnemies();
        dealer.initCards();
        nextTurn();
    }
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    public boolean nextTurn(){
        boolean stateOK = nextTurnAllowed();
        if(stateOK){
            currentMonster = dealer.nextMonster();
            currentPlayer = nextPlayer();
            boolean dead = currentPlayer.isDead();
            if(dead)
                currentPlayer.initTreasures();
        }
        return stateOK;
    }
    public boolean endOfGame(CombatResult result){
        boolean fin=false;
        if(result == CombatResult.WINGAME)
            fin=true;
        return fin;
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
