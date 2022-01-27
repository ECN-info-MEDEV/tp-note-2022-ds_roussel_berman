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
    
    // Codes couleur pour l'affichage console
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
    public Plateau() {
        this.grille = new Pion[6][7];
    }
    /**
     * Permet de savoir à quelle ligne tombe le pion. Mis en public pour pouvoir faire les tests
     * @param colonne colonne demanée
     * @return 
     */
    public int quelleLigne(int colonne){
        int ligne = 5;
        
        while(this.grille[ligne][colonne] != null){
            ligne = ligne - 1;
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
        StringBuilder bld = new StringBuilder();
        String line;
        
        System.out.println(" C 1 2 3 4 5 6 7");
        System.out.println("L ===============");
        for(int i = 0; i < 6; i++) {
            bld = new StringBuilder();
            bld.append(i+1).append(" |");
            for(int j = 0; j < 7; j++) {
                if(this.grille[i][j] == null)
                    bld.append(" |");
                else if(this.grille[i][j].isYellow())
                    bld.append(ANSI_YELLOW + "○" + ANSI_RESET + "|");
                else {
                    bld.append(ANSI_RED + "•" + ANSI_RESET + "|");
                }
            }
            line = bld.toString();
            System.out.println(line);
        }
        System.out.println("  ===============");
    }

    public Pion[][] getGrille() {
        return grille;
    }

    public void setGrille(Pion[][] grille) {
        this.grille = grille;
    }
}
