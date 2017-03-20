#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame

require_relative 'treasure_kind'
require_relative 'prize'
require_relative 'bad_consequence'
require_relative 'monster'
require_relative 'player'
require_relative 'card_dealer'
require_relative 'dice'
require_relative 'treasure'

class PruebaNapakalaki

 @@monsters = Array.new

def self.CombatLevelMoreThan10
        tmp = Array.new
        @@monsters.each do |elemento|
          if elemento.getCombatLevel > 10
            tmp << elemento
          end
        end
    return tmp
end

def self.BadConsequenceOnlyLevel
        tmp = Array.new
        @@monsters.each do |elemento|
            aniadir=true;
            if elemento.getBadConsequence.death
                aniadir=false;
              elsif elemento.getBadConsequence.getNVisibleTreasures !=0 || elemento.getBadConsequence.getNHiddenTreasures != 0
                    aniadir=false  
            end
            if aniadir
                tmp << elemento
            end
        end
        return tmp
end

def self.PrizeLevelMoreThan1
        tmp = Array.new
        @@monsters.each do |elemento|
            if elemento.getLevelsGained > 1
               tmp << elemento
            end
        end      
        return tmp;
end

def self.LoseTreasureSpecific(treasure)
        monstruosT = Array.new
        @@monsters.each do |monstruo|
        added = false
        treasuresList = Array.new
        monstruo.getBadConsequence.getSpecificVisibleTreasures.each do |visible|
        treasuresList << visible
        end
        monstruo.getBadConsequence.getSpecificHiddenTreasures.each do |hidden|
        treasuresList << hidden
        end
        treasuresList.each do |tesoros|
           if (tesoros == treasure and !added)
              monstruosT << monstruo
              added = true
           end
        end
        end
        return monstruosT
end

#Monstruo1
prize = Prize.new(2,1)
badConsequence = 
  BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta",
  0,[TreasureKind::ARMOR], [TreasureKind::ARMOR])
@@monsters<<Monster.new("Byakhees de bonanza", 8, badConsequence, prize)

#Monstruo2
prize = Prize.new(1,1)
badConsequence = 
  BadConsequence.newLevelSpecificTreasures("Embotados con el lindo primigenio te descartas de tu casco visible",
  0,[TreasureKind::HELMET], Array.new)
@@monsters<<Monster.new("Tenochtitlan", 2, badConsequence, prize)

#Monstruo3
prize = Prize.new(1,1)
badConsequence = 
  BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. Pierdes el calzado visible",
  0,[TreasureKind::SHOE], Array.new)
@@monsters<<Monster.new("El sopor de Dunwich", 2, badConsequence, prize)

#Monstruo4
prize = Prize.new(4,1)
badConsequence = 
  BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",
  0,[TreasureKind::ONEHAND],[TreasureKind::ONEHAND])
@@monsters<<Monster.new("Demonios de Magaluf", 2, badConsequence, prize)

#Monstruo5
prize = Prize.new(3,1)
badConsequence = 
  BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles",
  0, 9999999, 0)
@@monsters<<Monster.new("El gorrón en el umbral", 13, badConsequence, prize)

#Monstruo6
prize = Prize.new(2,1)
badConsequence = 
  BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible",
  0,[TreasureKind::ARMOR], Array.new)
@@monsters<<Monster.new("H.P. Munchcraft", 6, badConsequence, prize)

#Monstruo7
prize = Prize.new(1,1)
badConsequence = 
  BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible",
  0,[TreasureKind::ARMOR], Array.new)
@@monsters<<Monster.new("Necrófago", 13, badConsequence, prize)

#Monstruo8
prize = Prize.new(3,2)
badConsequence = 
  BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3 tesoros visibles",
  5, 3, 0)
@@monsters << Monster.new("El rey de rosado", 13, badConsequence, prize)

#Monstruo9
prize = Prize.new(1,1)
badConsequence = 
  BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles",
  2,0,0)
@@monsters<<Monster.new("Flecher", 2, badConsequence, prize)

#Monstruo10
prize = Prize.new(2,1)
badConsequence = 
  BadConsequence.newDeath("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto")
@@monsters<<Monster.new("Los hondos", 8, badConsequence, prize)

#Monstruo11
prize = Prize.new(2,1)
badConsequence = 
  BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos",
  2,0,2)
@@monsters<<Monster.new("Semillas Cthulhu", 4, badConsequence, prize)

#Monstruo12
prize = Prize.new(2,1)
badConsequence = 
  BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible",
  0,[TreasureKind::ONEHAND],Array.new)
@@monsters<<Monster.new("Dameargo", 1, badConsequence, prize)

#Monstruo13
prize = Prize.new(2,1)
badConsequence = 
  BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles",3,0,0)
@@monsters<<Monster.new("Pollipólipo volante", 3, badConsequence, prize)

#Monstruo14
prize = Prize.new(3,1)
badConsequence = 
  BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estás muerto")
@@monsters<<Monster.new("YskhtihyssgGoth", 14, badConsequence, prize)

#Monstruo15
prize = Prize.new(3,1)
badConsequence = 
  BadConsequence.newDeath("La familia te atrapa. Estás muerto")
@@monsters<<Monster.new("Familia feliz", 1, badConsequence, prize)

#Monstruo16
prize = Prize.new(2,1)
badConsequence = 
  BadConsequence.newLevelSpecificTreasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",
  2,[TreasureKind::BOTHHANDS],Array.new)
@@monsters<<Monster.new("Roboggoth", 8, badConsequence, prize)

#Monstruo17
prize = Prize.new(1,1)
badConsequence = 
  BadConsequence.newLevelSpecificTreasures("Te asusta en la noche. Pierdes un casco visible",
  0,[TreasureKind::HELMET],Array.new)
@@monsters<<Monster.new("El espía sordo", 5, badConsequence, prize)

#Monstruo18
prize = Prize.new(2,1)
badConsequence = 
  BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",
  2,5,0)
@@monsters<<Monster.new("Tongue", 19, badConsequence, prize)

#Monstruo19
prize = Prize.new(2,1)
badConsequence = 
  BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",
  3,[TreasureKind::BOTHHANDS,TreasureKind::ONEHAND,TreasureKind::ONEHAND],Array.new)
@@monsters<<Monster.new("Bicéfalo", 21, badConsequence, prize)

a = BadConsequence.newDeath("JAJAJA")
puts a.getLevels()

b = Prize.new(Treasure.new("Bueno",7,[TreasureKind::HELMET]),1)

end

end