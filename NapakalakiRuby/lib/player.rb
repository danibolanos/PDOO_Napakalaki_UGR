#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame

class Player
  
  MAXLEVEL = 10
  
  private
  def bringToLife
    @dead = false
  end
  
  def getCombatLevel
    clevel = @level
    @visibleTreasures.each do |elemento|
      clevel += elemento.getBonus
    end
    return clevel
  end
  
  def incrementLevels(l)
    @level += l
    if(@level > MAXLEVEL)
      @level = MAXLEVEL
    end
  end
  
  def decrementLevels(l)
     @level -= l
    if(@level < 1)
      @level = 1
    end
  end
  
  def setPendingBadConsequence(b)
    @pendingBadConsequence = b
  end
  
  def applyPrize(m)
    #No se sabe
  end
  
  def applyBadConsequence(m)
    #No se sabe
  end
  
  def canMakeTreasureVisible(t)
    #No se sabe
  end
  
  def howManyVisibleTreasures(tKind)
    cuantos=0;
    @visibleTreasures.each do |elemento|
      if elemento.getType == tKind
        cuantos+1
      end
    end
    return cuantos
  end
  
  def dieIfNoTreasures
    if @visibleTreasures.empty? && @hiddenTreasures.empty?
      @dead = true
    end
  end
  
  def giveMeATreasure
    #No se sabe
  end
  
  def canYouGiveMeATreasure
    puedo=true;
    if @visibleTreasures.empty? && @hiddenTreasures.empty?
      puedo=false;
    end
    return puedo;
  end
  
  def haveStolen
    @canISteal=false
  end

  public
  
  def initialize(name)
    @name = name
    @level = 1
    @dead = true  
    @pendingBadConsequence = nil
    @visibleTreasures = Array.new
    @hiddenTreasures = Array.new
    @canISteal = true
    @enemy = nil
  end
  
  def getName
    return @name
  end
  
  def isDead
    return @dead
  end
  
  def getHiddenTreasures
    return @hiddenTreasures
  end
  
  def getVisibleTreasures
    return @visibleTreasures
  end
  
  def combat(m)
    #No se sabe
  end
  
  def makeTreasureVisible
    #No se sabe
  end
  
  def discardVisibleTreasure(t)
    #No se sabe
  end
  
  def discardHiddenTreasure(t)
    #No se sabe
  end
  
  def validState
    condicion = false;
    if @pendingBadConsequence.isEmpty && @hiddenTreasures.size < 5
      condicion = true;
    end
    return condicion;
  end
  
  def initTreasures
    #No se sabe
  end
  
  def getLevels
    return @level
  end
  
  def stealTreasure
    #No se sabe
  end
  
  def setEnemy(enemy)
    @enemy = enemy
  end
  
  def canISteal
    return @canISteal
  end
  
  def discardAllTreasures
    #No se sabe
  end
  
  def to_s
    cadena = "Nombre: #{@name}"
    cadena += "\nNivel: #{@level}"
    if @dead
      cadena += "\nEstá muerto"
    else
      cadena += "\nEstá vivo"
    end
    if @canISteal
      cadena += "\nPuede robar"
    else
      cadena += "\nNo puede robar"
      cadena += "\nEnemigo: #{@enemy}"
      cadena += "\nTesoros visibles: #{@visibleTreasures}"
      cadena += "\nTesoros ocultos: #{@hiddenTreasures}"
      cadena += "\nMal rollo a cumplir: #{@pendingBadConsequence}"
    end
    return cadena;    
  end
end

end
