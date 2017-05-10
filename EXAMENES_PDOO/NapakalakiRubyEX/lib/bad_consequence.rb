#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame
  
require_relative 'treasure_kind'
require_relative 'player'

class BadConsequence
  
  MAXTREASURES = 10
    
  private
  
  def initialize(t, l)
    @text = t
    @levels = l
  end

  public
  
=begin
  def isEmpty
    vacio=false
    if @nVisibleTreasures==-1 then
      if @specificVisibleTreasures.empty? && @specificHiddenTreasures.empty? then
      vacio = true
      end
    elsif @nVisibleTreasures==0 && @nHiddenTreasures==0
      vacio = true
    end
    vacio
  end
=end
  def getLevels
    @levels
  end
  def getDeath
    false
  end
=begin  
  def getNVisibleTreasures
    @nVisibleTreasures
  end
  
  def getNHiddenTreasures
    @nHiddenTreasures
  end
  
  def getSpecificHiddenTreasures
    @specificHiddenTreasures
  end
  
  def getSpecificVisibleTreasures
    @specificVisibleTreasures
  end
  
  def substractVisibleTreasure(t)
    if @nVisibleTreasures == -1 then
      indice = @specificVisibleTreasures.find_index(t.getType)
      if indice != nil then
        @specificVisibleTreasures.delete_at(indice)
      end
    elsif @nVisibleTreasures > 0 then
      @nVisibleTreasures -= 1
    end
  end
  
  def substractHiddenTreasure(t)
    if @nHiddenTreasures == -1 then
      indice = @specificHiddenTreasures.find_index(t.getType)
      if indice != nil then
        @specificHiddenTreasures.delete_at(indice)
      end
    elsif @nHiddenTreasures > 0 then
      @nHiddenTreasures -= 1
    end
  end
  
  def adjustToFitTreasureLists(v, h)
    if @nVisibleTreasures == -1 then
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
      bc = BadConsequence.newLevelSpecificTreasures(@text, @levels, visible, hidden)
    else
      n_visible = @nVisibleTreasures
      n_hidden = @nHiddenTreasures
      if v.size < n_visible then
        n_visible = v.size
      end
      if h.size < n_hidden then
      n_hidden = h.size
      end
      bc = BadConsequence.newLevelNumberOfTreasures(@text, @levels, n_visible, n_hidden)
    end
    bc
  end 
=end
  def to_s
    cadena = "#{@text}"
    if @levels != 0 then
        cadena += "\nLevels_Down = #{@levels}"
      end
    cadena
  end
  
  protected
  #attr_accessor :death
  
  #private_class_method :new

end
end