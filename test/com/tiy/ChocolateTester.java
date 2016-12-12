package com.tiy;

/**
 * Created by erronius on 12/12/2016.
 */

import static org.junit.Assert.*;



import com.tiy.ChocolateMaker;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.omg.PortableInterceptor.Interceptor;

public class ChocolateTester {

    ChocolateMaker chocMaker;
    @Before
    public void setUp() throws Exception {
        chocMaker = new ChocolateMaker();
    }

    @After
    public void tearDown() throws Exception {

    }

    //Format is small, big, goal
    @Test
    public void testSufficiency () throws Exception {
        int smalls = chocMaker.makeChocolate(5, 2, 15);
        assertEquals(5, smalls);
        smalls = chocMaker.makeChocolate(4, 2, 12);
        assertEquals(2, smalls);
        smalls = chocMaker.makeChocolate(1, 1, 5);
        assertEquals(0, smalls);
        smalls = chocMaker.makeChocolate(9, 0, 8);
        assertEquals(8, smalls);
        smalls = chocMaker.makeChocolate(14, 2, 15);
        assertEquals(5, smalls);

    }

    @Test
    public void testInsufficiency () throws Exception {
        int smalls = chocMaker.makeChocolate(5, 2, 16);
        assertEquals(-1, smalls);
        smalls = chocMaker.makeChocolate(0, 2, 16);
        assertEquals(-1, smalls);
        smalls = chocMaker.makeChocolate(100, 1, 120);
        assertEquals(-1, smalls);
        smalls = chocMaker.makeChocolate(50, 2, 61);
        assertEquals(-1, smalls);
        smalls = chocMaker.makeChocolate(20, 2, 100000);
        assertEquals(-1, smalls);
    }

    @Test
    public void testGoalZero () throws Exception {
        int smalls = chocMaker.makeChocolate(0, 0, 0);
        assertEquals (0, smalls);
    }

    @Test
    public void testNegativeInputs () throws Exception {
        int smalls = chocMaker.makeChocolate(-1, -1, -1);
        assertEquals (-1, smalls);
        smalls = chocMaker.makeChocolate(-1, -1, 0);
        assertEquals (0, smalls);
        smalls = chocMaker.makeChocolate(-1, 0, 0);
        assertEquals (0, smalls);
        smalls = chocMaker.makeChocolate(0, -1, 0);
        assertEquals (0, smalls);
    }

    @Test
    public void testLargeInputs () throws Exception {
        int smalls = chocMaker.makeChocolate(1000, 5, 1005);
        assertEquals (980, smalls);
        smalls = chocMaker.makeChocolate(5, 200, 1004);
        assertEquals (4, smalls);
        smalls = chocMaker.makeChocolate(200, 20000, 5000);
        assertEquals (0, smalls);
        smalls = chocMaker.makeChocolate(10000, -1, 1000);
        assertEquals (1000, smalls);
    }

    @Test
    public void testOtherInputs () throws Exception {
        int smalls = chocMaker.makeChocolate(2, 0, 2);
        assertEquals (2, smalls);
        smalls = chocMaker.makeChocolate(6, 4, 19);
        assertEquals (4, smalls);
        smalls = chocMaker.makeChocolate(11, 11, 11);
        assertEquals (1, smalls);
        smalls = chocMaker.makeChocolate(Integer.MAX_VALUE, 0, Integer.MAX_VALUE);
        assertEquals (Integer.MAX_VALUE, smalls);
        smalls = chocMaker.makeChocolate(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals (Integer.MAX_VALUE % 5, smalls);
    }
}
