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
     * Cette méthode permet de savoir à quelle ligne tombe le pion. La méthode est mise en public afin de pouvoir la tester.
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
     * Cette méthode permet d'insérer le pion , s'il est possible de le faire. si c'est impossible, la fonction retourne false et le joueur doit renseigner un nouveau colonne.
     * @param isYellow couleur du pion
     * @param colonne colonne demandée
     * @return 
     */
    public boolean insererPion(Joueur joueur, int colonne) {
        boolean res = true;
        if(colonne < 0 || colonne > 6){
            res = false;
        }
        else{
            if (this.grille[0][colonne] != null){
                res = false; // la colonne est déjà pleine
        }
            else{
                int ligne = quelleLigne(colonne);
                this.grille[ligne][colonne] = new Pion(joueur.isIsYellow());
                joueur.setNbPion(joueur.getNbPion() - 1);
            }
        }
        
        return res;
    }
    
    public void affichePlateau() {
        StringBuilder bld;
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
