#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame

class Prize
  
  public
  
  def initialize(t, l)
    @treasures = t
    @levels = l
  end
  
  def getTreasures
    return @treasures
  end
  
  def getLevels
    return @levels
  end
  
  def to_s
    cadena = "Treasures = #{@treasures} / Levels = #{@levels}"
    return cadena 
  end
end 

end