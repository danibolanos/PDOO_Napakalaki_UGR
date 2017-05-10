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
    @treasures
  end
  
  def getLevels
    @levels
  end
  
  def to_s
    cadena = "Treasures = #{@treasures} / Levels = #{@levels}"
    cadena 
  end
end 

end