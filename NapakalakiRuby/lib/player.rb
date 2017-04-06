#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
  
  require_relative 'bad_consequence'
  require_relative 'treasure'
  require_relative 'combat_result'

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
    tipo = t.getType
    puedo = true
    
    case tipo
     
    when TreasureKind::ONEHAND
        contador=0
        @visibleTreasures.each do|tesoro|
          if tesoro.getType == TreasureKind::BOTHHANDS
            puedo = false
          elsif tesoro.getType == TreasureKind::ONEHAND
            contador += 1
          end
        end
        if contador > 1
          puedo = false
        end
      
    when TreasureKind::BOTHHANDS
      @visibleTreasures.each do|tesoro|
          if tesoro.getType == tipo || tesoro.getType == TreasureKind::ONEHAND
            puedo = false
          end
      end
    else
      @visibleTreasures.each do|tesoro|
          if tesoro.getType == tipo
            puedo = false
          end
    end
    end
    return puedo
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
    indice = rand(@hiddenTreasures.length)
    return @hiddenTreasures.at(indice)
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
    indice = @visibleTreasures.find_index(t)
    @visibleTreasures.delete_at(indice)
    if @pendingBadConsequence != nil && !@pendingBadConsequence.isEmpty
      @pendingBadConsequence.substractVisibleTreasure(t)
    end
    dieIfNoTreasures
  end
  
  def discardHiddenTreasure(t)
    indice = @hiddenTreasures.find_index(t)
    @hiddenTreasures.delete_at(indice)
    if @pendingBadConsequence != nil && !@pendingBadConsequence.isEmpty
      @pendingBadConsequence.substractHiddenTreasure(t)
    end
    dieIfNoTreasures
  end
  
  def validState
    condicion = false;
    if (@pendingBadConsequence == nil || @pendingBadConsequence.isEmpty) && @hiddenTreasures.size < 5
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
