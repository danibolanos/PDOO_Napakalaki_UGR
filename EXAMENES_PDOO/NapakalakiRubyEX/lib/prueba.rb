#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative 'player'

module Prueba
    class Cualquiera < NapakalakiGame::Player
      @@bondad = 10
      @bondad=0
      def initialize(a)
        super
        @algo = 12
        self.class.incrementarBondad
      end
      
      def self.incrementarBondad
        @bondad += 1
      end
      
      def bondadVerdadera
        @@bondad
      end
      
      def self.bondad
        "#{@bondad}"
      end
      
      def to_s
        cadena = super
        cadena += "\nY además un pedrolín"
        cadena += "\nAñadido especial: bondad " + self.class.bondad
      end
    end
end
