/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ecn.ds;

import java.util.Scanner;

/**
 *
 * @author aberman
 */
public class Joueur {
    private int nbPion;
    private boolean isYellow;
    private Scanner scanner; 
    private static String entree="[ENTRÉE]";
    /**
     * constructeur du joueur
     * @param isYellow couleur de son pion
     */
    public Joueur(boolean isYellow) {
        this.nbPion = 21;
        this.isYellow = isYellow;
    }
    /**
     * Permet de faire jouer le joueur sur le plateau de jeu
     * @param plateau plateau commun aux deux jours
     */
    public void jouer(Plateau plateau) {
        scanner = new Scanner(System.in);

        int colonne;

        boolean colonneAccepted = false;
        while(!colonneAccepted){
            System.out.println(entree  + " Dans quelle colonne souhaites-tu mettre ton pion ?  :");
            colonne = scanner.nextInt();
            colonneAccepted = plateau.insererPion(isYellow, colonne); // si vrai, le pion a été placé
        }
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


    
}
