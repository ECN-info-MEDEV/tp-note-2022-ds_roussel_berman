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
    
    /**
     * Vérifie si le Puissance 4 est gagné à partir d'un objet de type Plateau
     * @param plateau
     * @return true s'il y a un gagnant, false sinon
     */
    public boolean verifierGagnant(Plateau plateau) {
        Pion[][] grille;
        grille = plateau.getGrille();
        
        // Vérifie si une série de 4 pions de la même couleur sont alignés horizontalement
        for (int i = 0; i < 6; i++) {
            int count = 1;
            if(grille[i][0] == null)
                continue;
            boolean color = grille[i][0].isYellow();
            for (int j = 1; j < 7; j++) {
                if(grille[i][j] == null)
                    continue;
                if(color == grille[i][j].isYellow())
                    count += 1;
                else {
                    count = 0;
                    color = grille[i][j].isYellow();
                }
                
                if(count == 4)
                    return (this.isYellow == color);
            }
        }
        
        // Vérifie si une série de 4 pions de la même couleur sont alignés verticalement
        for (int j = 0; j < 7; j++) {
            int count = 1;
            if(grille[0][j] == null)
                continue;
            boolean color = grille[0][j].isYellow();
            for (var i = 1; i < 6; i++) {
                if(grille[i][j] == null)
                    continue;
                if(color == grille[i][j].isYellow())
                    count += 1;
                else {
                    count = 0;
                    color = grille[i][j].isYellow();
                }
                
                if(count == 4)
                    return (this.isYellow == color);
            }
        }
        
        // Vérifie si une série de 4 pions de la même couleur sont alignés diagonalement
        for(int i = 3; i < 6; i++) {
            int j = 0;
            int count = 1;
            if(grille[i][j] == null)
                continue;
            boolean color = grille[i][j].isYellow();
            for(var k = i; k >= 0; k--) {
                if(grille[k][j] == null)
                    continue;
                if(color == grille[k][j].isYellow())
                    count += 1;
                else {
                    count = 0;
                    color = grille[k][j].isYellow();
                }
                
                if(count == 4)
                    return (this.isYellow == color);
                
                j++;
            }
            
        }
        
        for(int i = 2; i >= 0; i--) {
            int j = 6;
            int count = 1;
            if(grille[i][j] == null)
                continue;
            boolean color = grille[i][j].isYellow();
            for(var k = i; k < 6; k++) {
                if(grille[k][j] == null)
                    continue;
                if(color == grille[k][j].isYellow())
                    count += 1;
                else {
                    count = 0;
                    color = grille[k][j].isYellow();
                }
                
                if(count == 4)
                    return (this.isYellow == color);
                j--;
            }
        }
        
        return false;
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
