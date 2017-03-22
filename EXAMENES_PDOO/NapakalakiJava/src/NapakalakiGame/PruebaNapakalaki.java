/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;
import java.util.*;

/**
 *
 * @author danibolanos
 */
public class PruebaNapakalaki {
    static ArrayList<Monster> monstruos = new ArrayList();
    
    static ArrayList CombatLevelMoreThan10(){
        ArrayList<Monster> tmp = new ArrayList();
        for(int i=0; i < monstruos.size(); i++){
            if(monstruos.get(i).getCombatLevel() > 10)
               tmp.add(monstruos.get(i));
        }
        return tmp;
    }
    
    static ArrayList BadConsequenceOnlyLevel(){
        ArrayList<Monster> tmp = new ArrayList();
        boolean aniadir;
        for(int i=0; i < monstruos.size(); i++){
            aniadir=true;
            if(monstruos.get(i).getBadConsequence().getDeath())
                aniadir=false;
            else{
                if(monstruos.get(i).getBadConsequence().getNVisibleTreasures() !=0 
                        || monstruos.get(i).getBadConsequence().getNHiddenTreasures() != 0)
                    aniadir=false;
            }
            if(aniadir)
                tmp.add(monstruos.get(i));
        }
        return tmp;
    }
    
    static ArrayList PrizeLevelMoreThan1(){
        ArrayList<Monster> tmp = new ArrayList();
        for(int i=0; i < monstruos.size(); i++){
            if(monstruos.get(i).getPrize().getLevels() > 1)
               tmp.add(monstruos.get(i));
        }
        return tmp;
    }
    
    static ArrayList LoseTreasureSpecific(TreasureKind kind){
        ArrayList<Monster> tmp = new ArrayList();
        for(int i=0; i < monstruos.size(); i++){
            if(monstruos.get(i).getBadConsequence().getSpecificHiddenTreasures().contains(kind)
               || monstruos.get(i).getBadConsequence().getSpecificVisibleTreasures().contains(kind))
               tmp.add(monstruos.get(i));
        }
        return tmp;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        
        // TODO code application logic here
        
        //Monstruo 1
        BadConsequence badConsequence = new BadConsequence("Pierdes tu armadura visible y otra oculta.", 0, 
        new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        Prize prize = new Prize(2,1);
        monstruos.add(new Monster("3 Byakhees de bonanza", 8, badConsequence, prize));
        
        //Monstruo 2
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible.", 0, 
        new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1,1);
        monstruos.add(new Monster("Tenochtitlan", 2, badConsequence, prize));
        
        //Monstruo 3
        badConsequence = new BadConsequence("El primordial bostezo contagioso. Pierdes el calzado visible.", 0, 
        new ArrayList(Arrays.asList(TreasureKind.SHOE)), new ArrayList(Arrays.asList()));
        prize = new Prize(1,1);        
        monstruos.add(new Monster("El sopor de Dunwich", 2, badConsequence, prize));
        
        //Monstruo 4
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta.", 
        0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        monstruos.add(new Monster("Demonios de Magaluf", 2, badConsequence, prize));
        
        //Monstruo 5
        badConsequence = new BadConsequence("Pierdes todos tus tesoros visibles.", 0, Integer.MAX_VALUE, 0);
        prize = new Prize(3,1);
        monstruos.add(new Monster("El gorrón en el umbral", 13, badConsequence, prize));
        
        //Monstruo 6
        badConsequence = new BadConsequence("Pierdes la armadura visible.", 0, 
        new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize = new Prize(2,1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, badConsequence, prize));
        
        //Monstruo 7
        badConsequence = new BadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible.", 0, 
        new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize = new Prize(1,1);
        monstruos.add(new Monster("Necrófago", 13, badConsequence, prize));
   
        // Monstruo 8        
        badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
        prize = new Prize(3,2);
        monstruos.add(new Monster("El rey de rosado", 11, badConsequence, prize));
        
        // Monstruo 9        
        badConsequence = new BadConsequence("Toses los pulmones y pierdes 2 niveles.", 2, 0, 0);
        prize = new Prize(1,1);
        monstruos.add(new Monster("Flecher", 2, badConsequence, prize));
        
        // Monstruo 10      
        badConsequence = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estás muerto.", true);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Los Hondos", 8, badConsequence, prize));
        
        // Monstruo 11      
        badConsequence = new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos.", 2, 0, 2);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Semillas Cthulhu", 4, badConsequence, prize));
        
        // Monstruo 12
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes 1 mano visible.", 0, 
        new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        prize = new Prize(2,1);
        monstruos.add(new Monster("Dameargo", 1, badConsequence, prize));
        
        // Monstruo 13      
        badConsequence = new BadConsequence("Da mucho asquito. Pierdes 3 niveles.", 3, 0, 0);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Pollipólipo volante", 3, badConsequence, prize));
        
        // Monstruo 14  
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estás muerto.", true);
        prize = new Prize(3,1);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 14, badConsequence, prize));
        
        // Monstruo 15     
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto.", true);
        prize = new Prize(3,1);
        monstruos.add(new Monster("Familia Feliz", 1, badConsequence, prize));
        
        // Monstruo 16 
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible.", 2, 
        new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        prize = new Prize(2,1);
        monstruos.add(new Monster("Roboggoth", 8, badConsequence, prize));
        
        // Monstruo 17    
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible.", 0, 
        new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList(Arrays.asList()));
        prize = new Prize(1,1);
        monstruos.add(new Monster("El espía sordo", 5, badConsequence, prize));
        
        // Monstruo 18     
        badConsequence = new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.", 2, 5, 0);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Tongue", 19, badConsequence, prize));
        
        // Monstruo 19  
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.", 3, 
        new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        prize = new Prize(2,1);
        monstruos.add(new Monster("Bicéfalo", 21, badConsequence, prize));
        
        
        int tamanio=monstruos.size();
        System.out.println("Numero de monstruos: " + tamanio + "\n");
        for(Monster m:monstruos){
           System.out.println(m + "\n");
        }
        
        
        }
        
}  
            
