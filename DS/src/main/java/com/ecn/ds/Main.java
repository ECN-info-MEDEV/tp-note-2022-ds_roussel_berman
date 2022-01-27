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
        System.out.println("\nJOUEUR 2\n");
        Joueur joueur2 = new Joueur(false);
        System.out.println("[ENTRÉE]" + " Tapez votre pseudo :");
        nomJoueur = scanner.next();
        
        int n=0;
        boolean fini = false;
        while(!fini){
            
            if(n%2==0){
                grille.affichePlateau();
                System.out.println("à " + " de jouer! Tu es BLANC");
                joueur1.jouer(grille);
                n=1;
                if (joueur1.verifierGagnant(grille)){
                    fini = joueur1.verifierGagnant(grille);
                    System.out.println("animation joueur 1 a fini");
                }
            }
            else{
                grille.affichePlateau();
                System.out.println("à " +   " de jouer! Tu es BLANC");
                joueur2.jouer(grille);
                n=1;
                if (joueur2.verifierGagnant(grille)){
                    fini = joueur2.verifierGagnant(grille);
                    System.out.println("animation joueur 2 a fini");
                }
            }
        }
        
    }
}
