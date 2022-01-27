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
public class PlateauTest {
    
    public PlateauTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testQuelleLigne() {
        Plateau instance = new Plateau();
        assertEquals(instance.quelleLigne(0), 5);   
    }
    
    @Test
    public void testInsertPion() {
        Plateau instance = new Plateau();
        Joueur instancejoueur = new Joueur(true);
        assertTrue(instance.insererPion(instancejoueur, 0));
        
    }
    
    @Test
    public void testChangementPLateau() {
        Plateau instance = new Plateau();
        Joueur instancejoueur = new Joueur(true);
        instance.insererPion(instancejoueur, 0);
        assertEquals(instance.quelleLigne(0),4); // si vrai, alors un pion est bien tombé en ligne 5
    }
   @Test
    public void testAffichePlateau() {
        Plateau instance = new Plateau();
        instance.affichePlateau();
    }
    
    @Test
    public void testGetGrille() {
        Plateau instance = new Plateau();
        instance.getGrille()[0][0] = new Pion(true);
        assertTrue(instance.getGrille()[0][0].isYellow());
    }
    
}
