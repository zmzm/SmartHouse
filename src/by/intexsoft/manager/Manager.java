package by.intexsoft.manager;

import by.intexsoft.device.Conditioner;
import by.intexsoft.device.Light;
import by.intexsoft.device.Server;

import java.util.Random;

/**
 * Created by Admin on 19.07.2015.
 */
public class Manager implements Runnable {
    private Integer minTemp;
    private Integer maxTemp;
    private Integer startTime;
    private Integer endTime;
    private static Random random = new Random();

    Server server = new Server("Server");
    Conditioner conditioner = new Conditioner("Conditioner", server.generateID(), by.intexsoft.state.State.On);
    Light light = new Light("Light", server.generateID(), by.intexsoft.state.State.Off);

    public Manager(Integer startTime, Integer endTime, Integer maxTemp, Integer minTemp) {
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.startTime = startTime;
        this.endTime = endTime;

        conditioner.setTemperature(minTemp);
    }

    private static int randInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }

    @Override
    public void run() {
        System.out.println("Текущее время: " + startTime + ":00");
        System.out.println("Температура: " + minTemp);
        System.out.println("");

        while (startTime != endTime) {

            int m = randInt(5, 10);
            startTime++;
            System.out.println("Текущее время: " + startTime + ":00");
            minTemp += m;
            if (minTemp >= maxTemp) {
                //System.out.println(minTemp);
                System.out.println("Что-то жарковато, кондиционер включен");
                minTemp = 17;
                conditioner.setTemperature(minTemp);
                System.out.println("Температура: " + minTemp);
            } else if (minTemp <= 15) {
                //System.out.println(minTemp);
                System.out.println("Что-то холодновато, кондиционер включен");
                minTemp = 20;
                conditioner.setTemperature(minTemp);
                System.out.println("Температура: " + minTemp);
            } else {
                System.out.println("Температура: " + minTemp);
            }
            System.out.println("");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Конец :)");
    }
}
