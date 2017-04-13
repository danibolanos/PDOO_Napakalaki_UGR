#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
  
require_relative 'treasure_kind'
require_relative 'player'

class BadConsequence
  
  MAXTREASURES = 10
    
  private
  
  def initialize(t, l, nVisible, nHidden, v, h, death)
    @text = t
    @levels = l
    @nVisibleTreasures = nVisible
    @nHiddenTreasures = nHidden
    @death = death
    @specificVisibleTreasures = v
    @specificHiddenTreasures = h
  end

  public
  
  def isEmpty
    vacio=false
    if @nVisibleTreasures==0 && @nHiddenTreasures==0 && @specificVisibleTreasures.empty? && @specificHiddenTreasures.empty? then
      vacio=true
    end
    vacio
  end
  
  def getLevels
    @levels
  end
  
  def getNVisibleTreasures
    @nVisibleTreasures
  end
  
  def getNHiddenTreasures
    @nHiddenTreasures
  end
  
  def getSpecificHiddenTreasures
    @specificHiddenTreasures
  end
  
  def getSpecificVisibleTreasures
    @specificVisibleTreasures
  end
  
  def substractVisibleTreasure(t)
    if @nVisibleTreasures == -1 then
      indice = @specificVisibleTreasures.find_index(t.getType)
      if indice != nil then
        @specificVisibleTreasures.delete_at(indice)
      end
    elsif @nVisibleTreasures > 0 then
      @nVisibleTreasures -= 1
    end
  end
  
  def substractHiddenTreasure(t)
    if @nHiddenTreasures == -1 then
      indice = @specificHiddenTreasures.find_index(t.getType)
      if indice != nil then
        @specificHiddenTreasures.delete_at(indice)
      end
    elsif @nHiddenTreasures > 0 then
      @nHiddenTreasures -= 1
    end
  end

  def BadConsequence.newLevelNumberOfTreasures(t, l, nVisible, nHidden)
    new(t, l, nVisible, nHidden, Array.new, Array.new, false)
  end
  
  def BadConsequence.newLevelSpecificTreasures (t, l, v, h)
    new(t, l, -1, -1, v, h, false)
  end  
    
  def BadConsequence.newDeath (t)
    new(t, Player::MAXLEVEL, BadConsequence::MAXTREASURES, BadConsequence::MAXTREASURES, Array.new, Array.new, true)
  end  
  
  def adjustToFitTreasureLists(v,h)
    #No se sabe
  end 

  def to_s
    cadena = "#{@text}" 
    if @death then
      cadena += "\nDeath = #{@death}"
    else 
      if @levels != 0 then
        cadena += "\nLevels_Down = #{@levels}"
      end
      if @nVisibleTreasures == -1 then
         cadena += "\nSpecific_Visible_Treasures_Down = #{@specificVisibleTreasures} / Specific_Hidden_Treasures_Down = #{@specificHiddenTreasures}"
      else
         cadena += "\nRandom_Visible_Treasures_Down = #{@nVisibleTreasures} / Random_Hidden_Treasures_Down = #{@nHiddenTreasures}"
      end
    end 
    cadena
  end
  
  #attr_reader :death
  
  private_class_method :new

end
end