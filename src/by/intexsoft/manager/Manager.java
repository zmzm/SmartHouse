package by.intexsoft.manager;

import by.intexsoft.device.Conditioner;
import by.intexsoft.device.Light;
import by.intexsoft.device.Server;
import by.intexsoft.messenger.Messenger;
import by.intexsoft.state.States;

import java.util.Random;

/**
 * Created by Admin on 19.07.2015.
 */
public class Manager implements Runnable, Messenger {
    private static Integer minTemp;
    private static Integer maxTemp;
    private Integer startTime;
    private Integer endTime;
    private static Integer currentTime;
    private static Integer currentTemp;
    private static Random random = new Random();

    Server server = new Server("Server");
    Conditioner conditioner = new Conditioner("Conditioner", server.generateID(), States.On);
    Light light = new Light("Light", server.generateID(), States.Off);

    public Manager(Integer startTime, Integer endTime, Integer maxTemp, Integer minTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public static Integer getTime() {
        return currentTime;
    }

    public static Integer getTemp() {
        return currentTemp;
    }

    public static void setTemp(Integer t) {
        currentTemp = t;
    }

    public static Integer getMinTemp() {
        return minTemp;
    }

    public static Integer getMaxTemp() {
        return maxTemp;
    }

    private static int randInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    @Override
    public void run() {
        currentTime = startTime;
        currentTemp = minTemp;

        Thread lightThread = new Thread(light);
        lightThread.start();

        Thread conditionerThread = new Thread(conditioner);
        conditionerThread.start();


        while (currentTime != 1000) {
            int m = randInt(1, 5);
            currentTime++;

            if (currentTime > 24) {
                currentTime = 1;
            }

            currentTemp += m;
            System.out.println(message());

            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String message() {
        return "Текущее время: " + currentTime + ":00 " + " Температура " + getTemp();
    }
}
