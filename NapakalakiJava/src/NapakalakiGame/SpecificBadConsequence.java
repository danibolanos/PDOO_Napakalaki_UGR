/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author danibolanos & jomabose
 */
public class SpecificBadConsequence extends BadConsequence{
        public SpecificBadConsequence(String t, int l, ArrayList<TreasureKind> v,
        ArrayList<TreasureKind> h){
            super(t, l, -1, -1, v, h, false);
        }
}
