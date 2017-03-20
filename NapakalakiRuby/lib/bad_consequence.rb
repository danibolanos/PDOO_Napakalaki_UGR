#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
  
require_relative 'player'

class BadConsequence
  
  MAXTREASURES = 10
    
  public
  
  def initialize(t, l, nVisible, nHidden, v, h, death)
    @text = t
    @levels = l
    @nVisibleTreasures = nVisible
    @nHiddenTreasures = nHidden
    @death = death
    @specificVisibleTreasures = v
    @specificHiddenTreasures = h
  end

  def isEmpty
    vacio=false
    if @nVisibleTreasures==0 && @nHiddenTreasures==0 && @specificVisibleTreasures.empty? && @specificHiddenTreasures.empty?
      vacio=true
    end
    return vacio
  end
  
  def getLevels
    return @levels
  end
  
  def getNVisibleTreasures
    return @nVisibleTreasures
  end
  
  def getNHiddenTreasures
    return @nHiddenTreasures
  end
  
  def getSpecificHiddenTreasures
    return @specificHiddenTreasures
  end
  
  def getSpecificVisibleTreasures
    return @specificVisibleTreasures
  end
  
  def substractVisibleTreasure(t)
    #No se sabe
  end
  
  def substractHiddenTreasure(t)
    #No se sabe
  end

  def BadConsequence.newLevelNumberOfTreasures(t, l, nVisible, nHidden)
    BadConsequence.new(t, l, nVisible, nHidden, Array.new, Array.new, false)
  end
  
  def BadConsequence.newLevelSpecificTreasures (t, l, v, h)
    BadConsequence.new(t, l, -1, -1, v, h, false)
  end  
    
  def BadConsequence.newDeath (t)
    BadConsequence.new(t, Player::MAXLEVEL, BadConsequence::MAXTREASURES, BadConsequence::MAXTREASURES, Array.new, Array.new, true)
  end  
  
  def adjustToFitTreasureLists(v,h)
    #No se sabe
  end 

  def to_s
    cadena = "#{@text}" 
    if @death
      cadena += "\nDeath = #{@death}"
    else 
      if @levels != 0
        cadena += "\nLevels_Down = #{@levels}"
      end
      if @nVisibleTreasures == -1
         cadena += "\nSpecific_Visible_Treasures_Down = #{@specificVisibleTreasures} / Specific_Hidden_Treasures_Down = #{@specificHiddenTreasures}"
      else
         cadena += "\nRandom_Visible_Treasures_Down = #{@nVisibleTreasures} / Random_Hidden_Treasures_Down = #{@nHiddenTreasures}"
      end
    end 
    return cadena
  end
  
  attr_reader :death

end
end