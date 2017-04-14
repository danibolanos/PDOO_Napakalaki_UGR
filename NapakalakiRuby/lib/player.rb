#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
  
  require_relative 'treasure'
  require_relative 'bad_consequence'
  require_relative 'combat_result'
  require_relative 'dice'
  require_relative 'card_dealer'

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
    clevel
  end
  
  def incrementLevels(l)
    @level += l
    if(@level > MAXLEVEL) then
      @level = MAXLEVEL
    end
  end
  
  def decrementLevels(l)
     @level -= l
    if(@level < 1) then
      @level = 1
    end
  end
  
  def setPendingBadConsequence(b)
    @pendingBadConsequence = b
  end
  
  def applyPrize(m)
    nLevels = m.getLevelsGained
    incrementLevels(nLevels)
    nTreasures = m.getTreasuresGained
    if nTreasures > 0 then
      dealer = CardDealer.instance
      nTreasures.times do
        treasure = dealer.nextTreasure
        @hiddenTreasures << treasure
      end
    end
  end
  
  def applyBadConsequence(m)
    badConsequence = m.getBadConsequence
    nLevels = badConsequence.getLevels
    decrementLevels(nLevels)
    pendingBad = badConsequence.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)
    setPendingBadConsequence(pendingBad)
  end
  
  def canMakeTreasureVisible(t)
    tipo = t.getType
    puedo = true
    
    case tipo
     
    when TreasureKind::ONEHAND
        contador=0
        @visibleTreasures.each do|tesoro|
          if tesoro.getType == TreasureKind::BOTHHANDS then
            puedo = false
          elsif tesoro.getType == TreasureKind::ONEHAND then
            contador += 1
          end
        end
        if contador > 1 then
          puedo = false
        end
      
    when TreasureKind::BOTHHANDS
      @visibleTreasures.each do|tesoro|
          if tesoro.getType == tipo || tesoro.getType == TreasureKind::ONEHAND then
            puedo = false
          end
      end
    else
      @visibleTreasures.each do|tesoro|
          if tesoro.getType == tipo then
            puedo = false
          end
    end
    end
    puedo
  end
  
  def howManyVisibleTreasures(tKind)
    cuantos=0;
    @visibleTreasures.each do |elemento|
      if elemento.getType == tKind then
        cuantos+1
      end
    end
    cuantos
  end
  
  def dieIfNoTreasures
    if @visibleTreasures.empty? && @hiddenTreasures.empty? then
      @dead = true
    end
  end
  
  def giveMeATreasure
    indice = rand(@hiddenTreasures.length)
    @hiddenTreasures.at(indice)
  end
  
  def canYouGiveMeATreasure
    puedo=true
    if @visibleTreasures.empty? && @hiddenTreasures.empty? then
      puedo=false
    end
    puedo
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
    @name
  end
  
  def isDead
    @dead
  end
  
  def getHiddenTreasures
    @hiddenTreasures
  end
  
  def getVisibleTreasures
    @visibleTreasures
  end
  
  def combat(m)
    myLevel = getCombatLevel
    monsterLevel = m.getCombatLevel
    if !canISteal then
      dice = Dice.instance
      number = dice.nextNumber
      if number < 3 then
        enemyLevel = @enemy.getCombatLevel
        monsterLevel += enemyLevel
      end
    end
    if myLevel > monsterLevel then
      applyPrize(m)
      if getLevels >= MAXLEVEL then
        combatResult = CombatResult::WINGAME
      else
        combatResult = CombatResult::WIN
      end
    else
      applyBadConsequence(m)
      combatResult = CombatResult::LOSE
    end
    combatResult
  end
  
  def makeTreasureVisible(t)
    canI = canMakeTreasureVisible(t)
    if canI then
      @visibleTreasures << t
      indice = @hiddenTreasures.find_index(t)
      if indice != nil then
      @hiddenTreasures.delete_at(indice)
      end
    end
  end
  
  def discardVisibleTreasure(t)
    indice = @visibleTreasures.find_index(t)
    if indice != nil then
    @visibleTreasures.delete_at(indice)
    end
    if @pendingBadConsequence != nil && !@pendingBadConsequence.isEmpty then
      @pendingBadConsequence.substractVisibleTreasure(t)
    end
    dieIfNoTreasures
  end
  
  def discardHiddenTreasure(t)
    indice = @hiddenTreasures.find_index(t)
    if indice != nil then
      @hiddenTreasures.delete_at(indice)
    end
    if @pendingBadConsequence != nil && !@pendingBadConsequence.isEmpty then
      @pendingBadConsequence.substractHiddenTreasure(t)
    end
    dieIfNoTreasures
  end
  
  def validState
    condicion = false
    if (@pendingBadConsequence == nil || @pendingBadConsequence.isEmpty) && @hiddenTreasures.size < 5 then
      condicion = true
    end
    condicion
  end
  
  def initTreasures
    dealer = CardDealer.instance
    dice = Dice.instance
    bringToLife
    treasure = dealer.nextTreasure
    @hiddenTreasures << treasure
    number = dice.nextNumber
    if number == 6 then
      treasure = dealer.nextTreasure
      @hiddenTreasures << treasure
    elsif number > 1 then
      treasure = dealer.nextTreasure
      @hiddenTreasures << treasure
    end
  end
  
  def getLevels
    @level
  end
  
  def stealTreasure
    canI = canISteal
    if canI then
      canYou = @enemy.canYouGiveMeATreasure
      if canYou then
        treasure = @enemy.giveMeATreasure
        @hiddenTreasures << treasure
        haveStolen
      else
        treasure = nil
      end
    end
    treasure
  end
  
  def setEnemy(enemy)
    @enemy = enemy
  end
  
  def canISteal
    @canISteal
  end
  
  def discardAllTreasures
    copyVisible = Array.new(@visibleTreasures)
    copyHidden = Array.new(@hiddenTreasures)
    copyVisible.each do |treasure|
      discardVisibleTreasure(treasure)
    end
    copyHidden.each do |treasure|
      discardHiddenTreasure(treasure)
    end
  end
  
  def to_s
    cadena = "Nombre: #{@name}"
    cadena += "\nNivel: #{@level}"
    if @dead then
      cadena += "\nEstá muerto"
    else
      cadena += "\nEstá vivo"
    end
    if @canISteal then
      cadena += "\nPuede robar"
    else
      cadena += "\nNo puede robar"
      cadena += "\nEnemigo: #{@enemy}"
      cadena += "\nTesoros visibles: #{@visibleTreasures}"
      cadena += "\nTesoros ocultos: #{@hiddenTreasures}"
      cadena += "\nMal rollo a cumplir: #{@pendingBadConsequence}"
    end
    cadena   
  end
end

end
