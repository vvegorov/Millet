package com.example.mill.bean;

import com.example.mill.Mill;

import java.util.Queue;

public class MillState {
    private final int water;
    private final int millet;
    private final int flour;
    private final int power;

    private final boolean engine;
    private final boolean machine;

    public MillState(Mill mill, Queue<Water> water, Queue<Millet> millets, Queue<Flour> flours) {
        this.water = water.size();
        this.millet = millets.size();
        this.flour = flours.size();

        power = mill.getPower();
        engine = mill.isEngineOn();
        machine = mill.isMachineOn();
    }
}
