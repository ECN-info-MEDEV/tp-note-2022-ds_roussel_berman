/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecn.ds;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alanroussel
 */
public class JoueurTest {
    
    public JoueurTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    @Test
    public void testNbrPion() {
        Joueur instanceJoueur = new Joueur(true); // joueur est jaune
        assertEquals(instanceJoueur.getNbPion(), 21);   
    }
    @Test
    public void testNbrPionApresJoueur() {
        Joueur instanceJoueur = new Joueur(true); // joueur est jaune
        Plateau instancePlateau = new Plateau();
        instancePlateau.insererPion(instanceJoueur, 0);
        assertEquals(instanceJoueur.getNbPion(), 20);   
    }
    
    @Test
    public void testNonGagnant() {
        Joueur instanceJoueur = new Joueur(true); // joueur est jaune
        Plateau instancePlateau = new Plateau();
        assertFalse(instanceJoueur.verifierGagnant(instancePlateau)); // pas de faux positif
    }
    
    @Test
    public void testGagnantHorizontal(){
        Joueur instanceJoueur = new Joueur(true); // joueur est jaune
        Plateau instancePlateau = new Plateau();
        for(int j = 0; j < 4; j++){
            instancePlateau.getGrille()[0][j] = new Pion(true);
        }
        assertTrue(instanceJoueur.verifierGagnant(instancePlateau)); // pas de faux negatif
    }
    
    @Test
    public void testGagnantVertical(){
        Joueur instanceJoueur = new Joueur(true); // joueur est jaune
        Plateau instancePlateau = new Plateau();
        for(int i = 0; i < 4; i++){
            instancePlateau.getGrille()[i][0] = new Pion(true);
        }
        assertTrue(instanceJoueur.verifierGagnant(instancePlateau)); // pas de faux negatif
    }
}
