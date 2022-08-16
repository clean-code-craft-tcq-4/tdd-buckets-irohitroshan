package com.cleancode.tdd;



import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class ReadingCounterTest {

    ReadingCounter readingCounter = new ReadingCounter();

    @Test
    public void readingCountOfGivenRangeTest_invalid_startRange() throws Exception{

        Map<String,String> out = readingCounter.readingCountOfGivenRange(2,10);
        assertThat(out.get("2-10"), containsString("does not contain"));
    }

    @Test
    public void readingCountOfGivenRangeTest_invalid_endRange() throws Exception{

        Map<String,String> out = readingCounter.readingCountOfGivenRange(4,20);
        assertThat(out.get("4-20"), containsString("does not contain"));
    }

    @Test
    public void readingCountOfGivenRangeTest_invalid_Range() throws Exception{

        Map<String,String> out = readingCounter.readingCountOfGivenRange(4,10);
        assertThat(out.get("4-10"), containsString("Invalid Range"));
    }

    @Test
    public void readingCountOfGivenRangeTest_valid_Range() throws Exception{

        Map<String,String> out = readingCounter.readingCountOfGivenRange(4,5);
        assertEquals("2",out.get("4-5"));
    }

    @Test
    public void readingCountOfGivenRangeTest_validRange_withDuplicate() throws Exception{

        Map<String,String> out = readingCounter.readingCountOfGivenRange(3,5);
        assertEquals("4",out.get("3-5"));
    }


}
