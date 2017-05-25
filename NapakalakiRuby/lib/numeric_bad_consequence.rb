# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative 'bad_consequence'

module NapakalakiGame
  class NumericBadConsequence < BadConsequence
    
    MAXTREASURES = 10
      
    def initialize(t, l, nVisible, nHidden)
      bc = super(t, l)
      @nVisibleTreasures=nVisible
      @nHiddenTreasures=nHidden
    end
  
    def getNVisibleTreasures
      @nVisibleTreasures
    end
  
    def getNHiddenTreasures
      @nHiddenTreasures
    end
    
    def isEmpty
      vacio=false
      if @nVisibleTreasures==0 && @nHiddenTreasures==0
        vacio = true
      end
      vacio
    end
  
    def substractVisibleTreasure(t)
      if @nVisibleTreasures > 0 then
        @nVisibleTreasures -= 1
      end
    end 
    
    def substractHiddenTreasure(t)
      if @nHiddenTreasures > 0 then
        @nHiddenTreasures -= 1
      end
    end
    
    def adjustToFitTreasureLists(v, h)
      n_visible = @nVisibleTreasures
      n_hidden = @nHiddenTreasures
      if v.size < n_visible then
        n_visible = v.size
      end
      if h.size < n_hidden then
      n_hidden = h.size
      end
      bc = NumericBadConsequence.new(@text, @levels, n_visible, n_hidden)
      bc
    end

    def to_s
      cadena = super
      cadena += "\nRandom_Visible_Treasures_Down = #{@nVisibleTreasures} / Random_Hidden_Treasures_Down = #{@nHiddenTreasures}"
      cadena
    end
    
      public_class_method :new
  
  end
end
