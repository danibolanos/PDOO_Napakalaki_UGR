#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame

require 'singleton'
require_relative 'player'
require_relative 'card_dealer'
require_relative 'monster'
require_relative 'combat_result'

class Napakalaki
  include Singleton
  
  private
  
  def initialize
    @currentMonster = nil
    @currentPlayer = nil
    @players = nil
    @dealer = nil
  end

  def initPlayers(names)
    @players = Array.new
    names.each do |nombre|
       @players << Player.new(nombre)
    end
  end
  
  def nextPlayer
    index = 0
    if @currentPlayer == nil then
       index = rand(@players.size)
    else
      index = @players.index(@currentPlayer) + 1
      if index == @players.size then
        index = 0        
      end
    end
    @currentPlayer = @players.at(index)
    @players.at(index)
  end
  
  def nextTurnAllowed
    condicion = false
    if @currentPlayer == nil || @currentPlayer.validState then
      condicion = true
    end
    condicion
  end
  
  def setEnemies
    @players.each do |jugador|
      enemigo = rand((@players.size)-1)
      if enemigo == @players.index(jugador) then
       enemigo = (@players.size)-1
      end
       jugador.setEnemy(@players.at(enemigo))
    end
  end
  
  public
  
  def developCombat
    combatResult = @currentPlayer.combat(@currentMonster)
    @dealer.giveMonsterBack(@currentMonster)
    combatResult
  end
  
  def discardVisibleTreasures(treasures)
    treasures.each do |treasure|
      @currentPlayer.discardVisibleTreasure(treasure)
      @dealer.giveTreasureBack(treasure)
    end
  end
  
  def discardHiddenTreasures(treasures)
    treasures.each do |treasure|
      @currentPlayer.discardHiddenTreasure(treasure)
      @dealer.giveTreasureBack(treasure)
    end
  end
  
  def makeTreasuresVisible(treasures)
    treasures.each do |t|
      @currentPlayer.makeTreasureVisible(t)
    end
  end
  
  def initGame(players)
    initPlayers(players)
    setEnemies
    @dealer = CardDealer.instance
    @dealer.initCards
    nextTurn
  end
  
  def getCurrentPlayer
    @currentPlayer
  end
  
  def getCurrentMonster
    @currentMonster
  end
  
  def nextTurn
    stateOK = nextTurnAllowed
    if stateOK then
      @currentMonster = @dealer.nextMonster
      @currentPlayer = nextPlayer
      dead = @currentPlayer.isDead
      if dead then
        @currentPlayer.initTreasures
      end
    end
    stateOK
  end
  
  def endOfGame(result)
    condicion = false
    if result == [CombatResult::WINGAME] then
      condicion = true
    end
    condicion
  end 
end

end