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
    private String nom;
    private Scanner scanner;
    
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
            System.out.println("Dans quelle colonne souhaites-tu mettre ton pion ?  :");
            colonne = scanner.nextInt();
            colonne = colonne - 1; // décalage de 1.
            colonneAccepted = plateau.insererPion(this, colonne); // si vrai, le pion a été placé
            if(!colonneAccepted){
                System.out.println("La colonne que tu as choisis n'est pas disponible ... ");
            }
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
        for(int j = 0; j < 7; j++) {
            for(var i = 0; i < 3; i++) {
                if (grille[i][j] == null)
                    continue;
                
                boolean color = grille[i][j].isYellow();
                boolean check = true;
                for(var k = i; k < i+4; k++) {
                    if (color != grille[k][j].isYellow())
                        check = false;
                }
                
                if(check)
                    return (this.isYellow == color);
            }
        }
        
        // Vérifie si une série de 4 pions de la même couleur sont alignés diagonalement
        for(int i = 3; i < 6; i++) {
            int j = 0;
            int count = 0;
            if(grille[i][j] == null)
                continue;
            boolean color = grille[i][j].isYellow();
            for(var k = i; k >= 0; k--) {
                if(grille[k][j] == null) {
                    count = 0;
                    continue;
                }
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    
}
