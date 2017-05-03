#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
  
require_relative 'prize'
require_relative 'death_bad_consequence'
require_relative 'numeric_bad_consequence'
require_relative 'specific_bad_consequence'


class Monster
  
  def initialize(n, l, badConsequence, p, lC=0)
    @name = n
    @combatLevel = l
    @badConsequence = badConsequence
    @prize = p
    @levelChangeAgainstCultistPlayer = lC
  end
  
  def getName
    @name
  end
  
  def getCombatLevel
    @combatLevel
  end
  
  def getBadConsequence
    @badConsequence
  end
  
  def getLevelsGained
    @prize.getLevels
  end
  
  def getTreasuresGained
    @prize.getTreasures
  end
  
  def getCombatLevelAgainstCultistPlayer
    result = getCombatLevel + @levelChangeAgainstCultistPlayer
  end
  
  def to_s
    cadena = "Name: #{@name} \nCombat_Level: #{@combatLevel}"
    cadena += "\nPrize: #{@prize} \nBad_Consequence: #{@badConsequence}"
    cadena += "\n\n"
    cadena
  end
end

end