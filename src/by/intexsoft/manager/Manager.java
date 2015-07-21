package by.intexsoft.manager;

import by.intexsoft.device.Conditioner;
import by.intexsoft.device.Light;
import by.intexsoft.device.Server;
import by.intexsoft.enviroment.EnvironmentData;
import by.intexsoft.messenger.Messenger;
import by.intexsoft.parser.Parser;
import by.intexsoft.state.States;

import java.util.Random;

/**
 * Created by Admin on 19.07.2015.
 */
public class Manager implements Runnable, Messenger {
    private static Random random = new Random();
    private static Integer[] array = Parser.getData();

    public static EnvironmentData environmentData = new EnvironmentData(array[0], array[1], array[2], array[3]);
    public Server server = new Server("Server");
    public Conditioner conditioner = new Conditioner("Conditioner", server.generateID(), States.On);
    public Light light = new Light("Light", server.generateID(), States.Off);

    @Override
    public void run() {
        Thread environmentThread = new Thread(environmentData);
        environmentThread.start();

        Thread lightThread = new Thread(light);
        lightThread.start();

        Thread conditionerThread = new Thread(conditioner);
        conditionerThread.start();

        while (true) {
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
        return "Текущее время: " + environmentData.getTime() + ":00 " + " Температура " + environmentData.getTemp();
    }
}
