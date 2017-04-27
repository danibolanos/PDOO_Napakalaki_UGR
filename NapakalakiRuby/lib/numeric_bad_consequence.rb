# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
  class NumericBadConsequence < BadConsequence
    def initialize(t, l, nVisible, nHidden, d=false)
      super(t, l, nVisible, nHidden, Array.new, Array.new, d)
    end
  end
end
