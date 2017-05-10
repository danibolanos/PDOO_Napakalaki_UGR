# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative 'numeric_bad_consequence'

module NapakalakiGame
  class DeathBadConsequence < NumericBadConsequence
    def initialize(t)
      a=super(t, Player::MAXLEVEL, MAXTREASURES, MAXTREASURES)
    end
    
    def getDeath
      true
    end
    
    def to_s
      cadena = super + "\nDeath: #{@death}"
    end
    
  end
end
