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
public class Main {
    public static void main(String[] args){
        Plateau grille = new Plateau();
        
        Scanner scanner; 
        System.out.println("\nJOUEUR 1\n");
        Joueur joueur1 = new Joueur(true);
        scanner = new Scanner(System.in);
        System.out.println("[ENTRÉE]" + " Tapez votre pseudo :");
        String nomJoueur = scanner.next();
        joueur1.setNom(nomJoueur);
        System.out.println("\nJOUEUR 2\n");
        Joueur joueur2 = new Joueur(false);
        System.out.println("[ENTRÉE]" + " Tapez votre pseudo :");
        nomJoueur = scanner.next();
        joueur2.setNom(nomJoueur);
        
        int n=0;
        boolean fini = false;
        while(!fini){
            
            if(n%2==0){
                grille.affichePlateau();
                System.out.println("à " + joueur1.getNom() + " de jouer! Tu es JAUNE");
                System.out.println("tu as " + joueur1.getNbPion() + " pions à jouer");
                joueur1.jouer(grille);
                n=1;
                if (joueur1.verifierGagnant(grille)){
                    fini = joueur1.verifierGagnant(grille);
                    grille.affichePlateau();
                    System.out.println("[FIN DE LA PARTIE] Bravo " + joueur1.getNom() + ", tu as gagné ! ");
                }
            }
            else{
                grille.affichePlateau();
                System.out.println("à " + joueur2.getNom() +  " de jouer! Tu es ROUGE");
                System.out.println("tu as " + joueur2.getNbPion() + " pions à jouer");
                joueur2.jouer(grille);
                n=0;
                if (joueur2.verifierGagnant(grille)){
                    fini = joueur2.verifierGagnant(grille);
                    grille.affichePlateau();
                    System.out.println("[FIN DE LA PARTIE] Bravo " + joueur2.getNom() + ", tu as gagné ! ");
                }
                else{
                    if(joueur2.getNbPion() == 0){
                        System.out.println("[FIN DE LA PARTIE] Vous n'avez plus de pions ... ");
                    }
                }
            }
        }
        
       
    }
}
