#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame

class Treasure
  
  public
  
  def initialize(n, bonus, t)
    @name = n
    @bonus = bonus
    @type = t
  end
  
  def getName
    return @name
  end
  
  def getBonus
    return @bonus
  end
  
  def getType
    return @type
  end
  
  def to_s
    cadena = "#{@name}"
    cadena += "\nBonus: #{@bonus}"
    cadena += "\nTipo: #{@type}"
    return cadena;
  end
end

end
