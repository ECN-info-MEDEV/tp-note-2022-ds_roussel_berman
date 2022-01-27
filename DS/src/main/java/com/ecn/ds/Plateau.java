/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecn.ds;

/**
 *
 * @author aberman
 */
public class Plateau {
    private Pion[][] grille;
    
    public Plateau() {
        this.grille = new Pion[6][7];
    }
    
    public boolean insererPion(boolean isYellow, int colonne) {
        
        return true;
    }
    
    public void afficherPlateau() {
        
    }

    public Pion[][] getGrille() {
        return grille;
    }

    public void setGrille(Pion[][] grille) {
        this.grille = grille;
    }
}
