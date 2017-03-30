#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame

require 'singleton'

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
    names.each do |nombre|
       @players << new.Player(nombre)
    end
  end
  
  def nextPlayer
    index = 0
    if @currentPlayer == nil
       index = rand(@players.size)
    else
      index = @players.index(@currentPlayer) + 1
      if index == @players.size
        index = 0        
      end
    end
    @currentPlayer = @player.at(index)
    @player.at(index)
  end
  
  def nextTurnIsAllowed
    condicion = false
    if @currentPlayer == nil || @currentPlayer.validState
      condicion = true
    end
    condicion
  end
  
  def setEnemies
    @players.each do |jugador|
      enemigo = rand((@players.size)-1)
      if enemigo == @players.index(jugador) 
       enemigo = (@player.size)-1
      end
       jugador.setEnemy(@players.at(enemigo))
    end
  end
  
  public
  
  def developCombat
    #No se sabe
  end
  
  def discardVisibleTreasures(treasures)
    #No se sabe
  end
  
  def discardHiddenTreasures(treasures)
    #No se sabe
  end
  
  def makeTreasuresVisible(treasures)
    #No se sabe
  end
  
  def initGame(players)
    
  end
  
  def getCurrentPlayer
    @currentPlayer
  end
  
  def getCurrentMonster
    @currentMonster
  end
  
  def nextTurn
    #No se sabe
  end
  
  def endOfGame(result)
    condicion = false
    if result == [CombatResult::WINGAME] 
      condicion = true
    end
    condicion
  end 
end

end