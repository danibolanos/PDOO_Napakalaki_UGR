#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame

class Monster
  
  public
  
  def initialize(n, l, b, p)
    @name = n
    @combatLevel = l
    @badConsequence = b
    @prize = p
  end
  
  def getName
    return @name
  end
  
  def getCombatLevel
    return @combatLevel
  end
  
  def getBadConsequence
    return @badConsequence
  end
  
  def getLevelsGained
    return @prize.getLevels
  end
  
  def getTreasuresGained
    return @prize.getTreasures
  end
  
  def to_s
    cadena = "Name: #{@name} \nCombat_Level: #{@combatLevel}"
    cadena += "\nPrize: #{@prize} \nBad_Consequence: #{@badConsequence}"
    cadena += "\n\n"
    return cadena
  end
end

end