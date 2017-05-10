# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative 'prueba'

module Prueba
  class Prueba2 < Cualquiera
    @bondad=0
    def initialize(n)
      super
      @@bondad += 1
    end
    def getLevels
      super+9000
    end
  end
  a = Prueba2.new('Juanito')
  b = Prueba2.new('Pepito')
  c = Prueba2.new("menganito")
  puts a
  puts "\n"
  puts b.getLevels
  puts "\n"
  puts c.bondadVerdadera
  d=Cualquiera.new('Cuack')
  puts "\n"
  puts d
  puts "\n"
  puts d.bondadVerdadera
  
end
