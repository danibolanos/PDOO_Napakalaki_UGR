#encoding: utf-8
# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

module NapakalakiGame

require 'singleton'

class CardDealer
  include Singleton
  
  public
  
  def initialize
    @unusedMonsters = Array.new
    @usedMonsters = Array.new
    @unusedTreasures = Array.new
    @usedTreasures = Array.new
  end
  
  private
  def initTreasureCardDeck
    @unusedTreasures << Treasure.new("¡Sí, mi amo!",3,[TreasureKind::HELMET])
    @unusedTreasures << Treasure.new("Botas de investigación",3,[TreasureKind::SHOE])
    @unusedTreasures << Treasure.new("Capucha de Cthulhu",3,[TreasureKind::HELMET])
    @unusedTreasures << Treasure.new("A prueba de babas",2,[TreasureKind::ARMOR])
    @unusedTreasures << Treasure.new("Botas de lluvia ácida",1,[TreasureKind::BOTHHANDS])
    @unusedTreasures << Treasure.new("Casco minero",2,[TreasureKind::HELMET])
    @unusedTreasures << Treasure.new("Ametralladora ACME",1,[TreasureKind::BOTHHANDS])
    @unusedTreasures << Treasure.new("Camiseta de la ETSIIT",1,[TreasureKind::ARMOR])
    @unusedTreasures << Treasure.new("Clavo de rail ferroviario",3,[TreasureKind::ONEHAND])
    @unusedTreasures << Treasure.new("Cuchillo de sushi arcano",2,[TreasureKind::ONEHAND])
    @unusedTreasures << Treasure.new("Fez alópodo",3,[TreasureKind::HELMET])
    @unusedTreasures << Treasure.new("Hacha prehistórica",2,[TreasureKind::ONEHAND])
    @unusedTreasures << Treasure.new("El aparato del Pr. Tesla",4,[TreasureKind::ARMOR])
    @unusedTreasures << Treasure.new("Gaita",4,[TreasureKind::BOTHHANDS])
    @unusedTreasures << Treasure.new("Insecticida",2,[TreasureKind::ONEHAND])
    @unusedTreasures << Treasure.new("Escopeta de 3 cañones",4,[TreasureKind::BOTHHANDS])
    @unusedTreasures << Treasure.new("Garabato mísitco",2,[TreasureKind::ONEHAND])
    @unusedTreasures << Treasure.new("La rebeca metálica",32,[TreasureKind::ARMOR])
    @unusedTreasures << Treasure.new("Lanzallamas",4,[TreasureKind::BOTHHANDS])
    @unusedTreasures << Treasure.new("Necrocomicón",1,[TreasureKind::ONEHAND])
    @unusedTreasures << Treasure.new("Necronomicón",5,[TreasureKind::BOTHHANDS])
    @unusedTreasures << Treasure.new("Linterna a 2 manos",3,[TreasureKind::BOTHHANDS])
    @unusedTreasures << Treasure.new("Necrognomicón",2,[TreasureKind::ONEHAND])
    @unusedTreasures << Treasure.new("Necrotelecom",2,[TreasureKind::HELMET])
    @unusedTreasures << Treasure.new("Mazo de los antiguos",3,[TreasureKind::ONEHAND])
    @unusedTreasures << Treasure.new("Necroplayboycón",3,[TreasureKind::ONEHAND])
    @unusedTreasures << Treasure.new("Porra preternatural",2,[TreasureKind::ONEHAND])
    @unusedTreasures << Treasure.new("Shogulador",1,[TreasureKind::BOTHHANDS])
    @unusedTreasures << Treasure.new("Varita de atizamiento",3,[TreasureKind::ONEHAND])
    @unusedTreasures << Treasure.new("Tentáculo de pega",2,[TreasureKind::HELMET])
    @unusedTreasures << Treasure.new("Zapato deja-amigos",1,[TreasureKind::SHOE])
  end
  
  def initMonsterCardDeck
    #Monstruo1
    prize = Prize.new(2,1)
    badConsequence = 
    BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta",
    0,[TreasureKind::ARMOR], [TreasureKind::ARMOR])
    @unusedmonsters << Monster.new("Byakhees de bonanza", 8, badConsequence, prize)
    
    #Monstruo2
    prize = Prize.new(1,1)
    badConsequence = 
    BadConsequence.newLevelSpecificTreasures("Embotados con el lindo primigenio te descartas de tu casco visible",
    0,[TreasureKind::HELMET], Array.new)
    @unusedmonsters << Monster.new("Tenochtitlan", 2, badConsequence, prize)

    #Monstruo3
    prize = Prize.new(1,1)
    badConsequence = 
    BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. Pierdes el calzado visible",
    0,[TreasureKind::SHOE], Array.new)
    @unusedmonsters << Monster.new("El sopor de Dunwich", 2, badConsequence, prize)

    #Monstruo4
    prize = Prize.new(4,1)
    badConsequence = 
    BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta",
    0,[TreasureKind::ONEHAND],[TreasureKind::ONEHAND])
    @unusedmonsters << Monster.new("Demonios de Magaluf", 2, badConsequence, prize)

    #Monstruo5
    prize = Prize.new(3,1)
    badConsequence = 
    BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles",
    0, BadConsequence::MAXTREASURES, 0)
    @unusedmonsters << Monster.new("El gorrón en el umbral", 13, badConsequence, prize)

    #Monstruo6
    prize = Prize.new(2,1)
    badConsequence = 
    BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible",
    0,[TreasureKind::ARMOR], Array.new)
    @unusedmonsters << Monster.new("H.P. Munchcraft", 6, badConsequence, prize)

    #Monstruo7
    prize = Prize.new(1,1)
    badConsequence = 
    BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible",
    0,[TreasureKind::ARMOR], Array.new)
    @unusedmonsters << Monster.new("Necrófago", 13, badConsequence, prize)

    #Monstruo8
    prize = Prize.new(3,2)
    badConsequence = 
    BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3 tesoros visibles",
    5, 3, 0)
    @unusedmonsters << Monster.new("El rey de rosado", 13, badConsequence, prize)

    #Monstruo9
    prize = Prize.new(1,1)
    badConsequence = 
    BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles",
    2,0,0)
    @unusedmonsters << Monster.new("Flecher", 2, badConsequence, prize)

    #Monstruo10
    prize = Prize.new(2,1)
    badConsequence = 
    BadConsequence.newDeath("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto")
    @unusedmonsters << Monster.new("Los hondos", 8, badConsequence, prize)

    #Monstruo11
    prize = Prize.new(2,1)
    badConsequence = 
    BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos",
    2,0,2)
    @unusedmonsters << Monster.new("Semillas Cthulhu", 4, badConsequence, prize)

    #Monstruo12
    prize = Prize.new(2,1)
    badConsequence = 
    BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible",
    0,[TreasureKind::ONEHAND],Array.new)
    @unusedmonsters << Monster.new("Dameargo", 1, badConsequence, prize)

    #Monstruo13
    prize = Prize.new(2,1)
    badConsequence = 
    BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles",3,0,0)
    @unusedmonsters << Monster.new("Pollipólipo volante", 3, badConsequence, prize)

    #Monstruo14
    prize = Prize.new(3,1)
    badConsequence = 
    BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estás muerto")
    @unusedmonsters << Monster.new("YskhtihyssgGoth", 14, badConsequence, prize)

    #Monstruo15
    prize = Prize.new(3,1)
    badConsequence = 
    BadConsequence.newDeath("La familia te atrapa. Estás muerto")
    @unusedmonsters << Monster.new("Familia feliz", 1, badConsequence, prize)

    #Monstruo16
    prize = Prize.new(2,1)
    badConsequence = 
    BadConsequence.newLevelSpecificTreasures("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible",
    2,[TreasureKind::BOTHHANDS],Array.new)
    @unusedmonsters << Monster.new("Roboggoth", 8, badConsequence, prize)

    #Monstruo17
    prize = Prize.new(1,1)
    badConsequence = 
    BadConsequence.newLevelSpecificTreasures("Te asusta en la noche. Pierdes un casco visible",
    0,[TreasureKind::HELMET],Array.new)
    @unusedmonsters << Monster.new("El espía sordo", 5, badConsequence, prize)

    #Monstruo18
    prize = Prize.new(2,1)
    badConsequence = 
    BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles",
    2,5,0)
    @unusedmonsters << Monster.new("Tongue", 19, badConsequence, prize)

    #Monstruo19
    prize = Prize.new(2,1)
    badConsequence = 
    BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos",
    3,[TreasureKind::BOTHHANDS,TreasureKind::ONEHAND,TreasureKind::ONEHAND],Array.new)
    @unusedmonsters << Monster.new("Bicéfalo", 21, badConsequence, prize)
  end
  
  def shuffleTreasures
    @unusedTreasures.shuffle!
  end
  
  def shuffleMonster
    @unusedMonster.shuffle!
  end
  
  public
  
  def nextTreasure
    #No se sabe
  end
  
  def nextMonster
    #No se sabe
  end
  
  def giveTreasureBack(t)
    @unusedTreasures << t
  end
  
  def giveMonsterBack(m)
    @unusedMonsters << m
  end
  
  def initCards
    #No se sabe
  end
  
  def to_s
    cadena = "Tesoros sin usar: #{@unusedTreasures}"
    cadena += "\nTesoros usados: #{@usedTreasures}"
    cadena += "\nMonstruos sin usar: #{@unusedMonsters}"
    cadena += "\nMonstruos sin usar: #{@usedMonsters}\n"
    return cadena;
  end
end

end
