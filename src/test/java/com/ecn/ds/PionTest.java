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
public class PionTest {
    

    @Test
    public void testIsYellow() {
        Pion instance = new Pion(true);
        assertEquals(instance.isYellow(), true);

    }

    @Test
    public void testsetYellow() {
        Pion instance = new Pion(true);
        instance.setYellow(false);
        assertEquals(instance.isYellow(), false);

    }
}
