#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame

require 'singleton'

class Dice
  include Singleton
  
  private
  
  def initialize
  end

  public
  
  def nextNumber
    rand(6)+1
  end
end

end