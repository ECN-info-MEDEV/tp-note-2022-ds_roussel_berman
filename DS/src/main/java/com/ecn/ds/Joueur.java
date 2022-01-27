/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecn.ds;

/**
 *
 * @author aberman
 */
public class Joueur {
    private int nbPion;
    private boolean isYellow;
    private boolean aGagne;
    
    public Joueur(boolean isYellow) {
        this.nbPion = 21;
        this.isYellow = isYellow;
    }
    
    public void jouer() {
        
    }
    
     public boolean verifierGagnant(Plateau plateau) {
        
        return true;
    }

    public int getNbPion() {
        return nbPion;
    }

    public void setNbPion(int nbPion) {
        this.nbPion = nbPion;
    }

    public boolean isIsYellow() {
        return isYellow;
    }

    public void setIsYellow(boolean isYellow) {
        this.isYellow = isYellow;
    }

    public boolean isaGagne() {
        return aGagne;
    }

    public void setaGagne(boolean aGagne) {
        this.aGagne = aGagne;
    }
    
}
