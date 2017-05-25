# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative 'bad_consequence'

module NapakalakiGame
  class SpecificBadConsequence < BadConsequence
    def initialize(t, l, v, h)
      bc = super(t, l)
      @specificVisibleTreasures = v
      @specificHiddenTreasures = h
    end
  
    def getSpecificHiddenTreasures
      @specificHiddenTreasures
    end
  
    def getSpecificVisibleTreasures
      @specificVisibleTreasures
    end
    
    def isEmpty
      vacio=false
      if @specificVisibleTreasures.empty? && @specificHiddenTreasures.empty? then
        vacio = true
      end
      vacio
    end
  
    def substractVisibleTreasure(t)
      indice = @specificVisibleTreasures.find_index(t.getType)
      if indice != nil then
        @specificVisibleTreasures.delete_at(indice)
      end
    end
  
    def substractHiddenTreasure(t)
      indice = @specificHiddenTreasures.find_index(t.getType)
      if indice != nil then
        @specificHiddenTreasures.delete_at(indice)
      end
    end
  
    def adjustToFitTreasureLists(v, h)
      visible = Array.new
      copy_Visible = Array.new(@specificVisibleTreasures)
      v.each do |t|
        tipo = t.getType
        fin = false
        i = 0
        while i <  copy_Visible.size && !fin
        if copy_Visible.at(i) == tipo then
          visible << copy_Visible.at(i)
          copy_Visible.delete_at(i)
          fin = true
        end
        i += 1
        end
      end
      hidden = Array.new
      copy_Hidden = Array.new(@specificHiddenTreasures)
      h.each do |t|
        tipo = t.getType
        fin = false
        i = 0
        while i <  copy_Hidden.size && !fin
        if copy_Hidden.at(i) == tipo then
          hidden << copy_Hidden.at(i)
          copy_Hidden.delete_at(i)
          fin = true
        end
        i += 1
        end
      end
      bc = SpecificBadConsequence.new(@text, @levels, visible, hidden)
      bc
    end 

    def to_s
      cadena = super
      cadena += "\nSpecific_Visible_Treasures_Down = #{@specificVisibleTreasures} / Specific_Hidden_Treasures_Down = #{@specificHiddenTreasures}" 
      cadena
    end
    
    public_class_method :new
  end
end
