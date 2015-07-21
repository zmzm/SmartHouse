package by.intexsoft.enviroment;

import by.intexsoft.random.Randomize;

import java.util.Random;

/**
 * Created by Admin on 21.07.2015.
 */
public class EnvironmentData implements Environment, Runnable {
    private Integer minTemp;
    private Integer maxTemp;
    private Integer startTime;
    private Integer endTime;
    private Integer currentTime;
    private Integer currentTemp;

    public EnvironmentData(Integer startTime, Integer endTime, Integer maxTemp, Integer minTemp) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
    }

    @Override
    public synchronized Integer getTime() {
        return currentTime;
    }

    @Override
    public synchronized Integer getMinTime() {
        return startTime;
    }

    @Override
    public synchronized Integer getMaxTime() {
        return endTime;
    }

    @Override
    public synchronized void setTime(Integer t) {
        currentTime = t;
    }

    @Override
    public synchronized Integer getTemp() {
        return currentTemp;
    }

    @Override
    public synchronized void setTemp(Integer t) {
        currentTemp = t;
    }

    @Override
    public synchronized Integer getMinTemp() {
        return minTemp;
    }

    @Override
    public synchronized Integer getMaxTemp() {
        return maxTemp;
    }

    @Override
    public void run() {
        try {
            currentTemp = getMinTemp();
            currentTime = getMinTime();

            while (currentTime != 1000) {
                int m = Randomize.randInt(1, 5);
                currentTime++;
                setTime(currentTime);

                if (currentTime > 24) {
                    currentTime = 1;
                }

                currentTemp += m;
                setTemp(currentTemp);
                Thread.sleep(2500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
