package com.example.mill;

import com.example.mill.bean.Flour;
import com.example.mill.bean.Millet;
import com.example.mill.bean.Water;
import com.example.mill.engine.Engine;
import com.example.mill.engine.WaterWheel;
import com.example.mill.machine.Machine;
import com.example.mill.machine.MillStone;

import java.util.Queue;

public class Mill extends Thread {
    private final Machine machine;
    private final Engine engine;

    public Mill(Queue<Water> warerFlow, Queue<Millet> milletFlow, Queue<Flour> flourFlow) {
        this.engine = new WaterWheel(warerFlow);
        this.engine.start();

        this.machine = new MillStone(engine, milletFlow, flourFlow);
        this.machine.start();
    }

    public boolean isMachineOn() {
        return this.machine.isOn();
    }

    public boolean isEngineOn() {
        return this.engine.getPower() > 0;
    }

    public int getPower(){
        return this.engine.getPower();
    }

    @Override
    public void run() {
        while(!isInterrupted())
        {
            if(engine.getPower()>0)
            {
                this.machine.on();
            }
        }
    }
}
