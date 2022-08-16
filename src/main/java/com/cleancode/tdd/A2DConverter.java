package com.cleancode.tdd;

import java.util.ArrayList;
import java.util.List;

public class A2DConverter {

    public List<Integer> a2DConverter(List<Integer> inputs, int sensorMinReading, int sensorMaxReading, int maxAmp, int minAmp) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Integer input : inputs) {
            if(outOfRangeInput(input,sensorMinReading,sensorMaxReading))
            {
                throw new IllegalArgumentException("value out of range");
            }

            int reading = convertToAmps(sensorMinReading, sensorMaxReading, maxAmp, minAmp, input);
            result.add(reading);
        }
        return result;
    }

    public int convertToAmps(int sensorMinReading, int sensorMaxReading, int maxAmp, int minAmp, Integer input) {
        return   Math.round(
                ((input - sensorMinReading) * (maxAmp - minAmp)) / (sensorMaxReading - sensorMinReading) +
                        minAmp);
    }

    public boolean outOfRangeInput(int value, int sensorMinReading, int sensorMaxReading) {
        return (value < sensorMinReading || value > sensorMaxReading);
    }

}
