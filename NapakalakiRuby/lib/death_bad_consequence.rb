# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
  class DeathBadConsequence < NumericBadConsequence
    def initialize(t)
      a=super(t, Player::MAXLEVEL, MAXTREASURES, MAXTREASURES,true)
    end
  end
end
