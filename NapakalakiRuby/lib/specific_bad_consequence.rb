# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
  class SpecificBadConsequence < BadConsequence
    def initialize(t, l, v, h)
      super(t, l, -1, -1, v, h, false)
    end
  end
end
