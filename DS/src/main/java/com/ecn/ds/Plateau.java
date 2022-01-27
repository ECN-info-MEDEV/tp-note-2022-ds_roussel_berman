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
    /**
     * Permet de savoir à quelle ligne tombe le pion. Mis en public pour pouvoir faire les tests
     * @param colonne colonne demanée
     * @return 
     */
    public int quelleLigne(int colonne){
        int ligne = 0;
        while( (ligne < 5) && (this.grille[ligne][colonne] == null)){
            ligne += 1;
        }
        return ligne;
    }
    /**
     * Permet d'insérer le pion s'il est possible de le faire. si c'est impossible, la fonction retourne false
     * @param isYellow couleur du pion
     * @param colonne colonne demandée
     * @return 
     */
    public boolean insererPion(boolean isYellow, int colonne) {
        boolean res = true;
        if (this.grille[0][colonne] != null){
            res = false; // la colonne est déjà pleine
        }
        else{
            int ligne = quelleLigne(colonne);
            this.grille[ligne][colonne] = new Pion(isYellow);
        }
        return res;
    }
    
    public void affichePlateau() {
        System.out.println("affichage du plateau à faire");
    }

    public Pion[][] getGrille() {
        return grille;
    }

    public void setGrille(Pion[][] grille) {
        this.grille = grille;
    }
}
