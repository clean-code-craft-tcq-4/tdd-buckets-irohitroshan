package com.cleancode.tdd;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class A2DConverterTest {


    A2DConverter a2DConverter = new A2DConverter();

    @Test
    public void test() throws Exception{

        boolean result = a2DConverter.outOfRangeInput(5000,0 , 4094);
        assertTrue(result);
    }

    @Test
    public void test1() throws Exception{

        boolean result = a2DConverter.outOfRangeInput(-1000,0 , 4094);
        assertTrue(result);
    }

    @Test
    public void test2() throws Exception{

        boolean result = a2DConverter.outOfRangeInput(2000,0 , 1023);
        assertTrue(result);
    }

    @Test
    public void test3() throws Exception{

        boolean result = a2DConverter.outOfRangeInput(-500,0 , 1023);
        assertTrue(result);
    }

    @Test
    public void test4() throws Exception{

        int result = a2DConverter.convertToAmps(0,4094 , 10, 0,1000);
        assertEquals(2,result);
    }

    @Test
    public void test6() throws Exception{

        List<Integer> _12Bitvalues = new ArrayList<>();
        _12Bitvalues.add(1000);
        _12Bitvalues.add(2000);
        _12Bitvalues.add(3000);
        _12Bitvalues.add(4000);


        List<Integer> result = a2DConverter.a2DConverter(_12Bitvalues, 0 ,4094 , 0,10);
        assertTrue(result.size()==4);
    }


    @Test
    public void test5() throws Exception{

        int result = a2DConverter.convertToAmps(0,1023 , 15, -15,700);
        assertEquals(5,result);
    }

    @Test
    public void test7() throws Exception{

        List<Integer> _10Bitvalues = new ArrayList<>();
        _10Bitvalues.add(100);
        _10Bitvalues.add(300);
        _10Bitvalues.add(500);
        _10Bitvalues.add(700);


        List<Integer> result = a2DConverter.a2DConverter(_10Bitvalues, 0 ,1023 , 15,-15);
        assertTrue(result.size()==4);
    }

}
