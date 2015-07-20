package by.intexsoft.device;

import by.intexsoft.manager.Manager;
import by.intexsoft.messenger.Messenger;
import by.intexsoft.personalId.ID;
import by.intexsoft.state.States;

/**
 * Created by Admin on 19.07.2015.
 */
public class Conditioner extends AbstractDevice implements Runnable, Messenger {
    private String name;
    private ID<Integer> id;
    private int temperature;
    private States state;
    private boolean check = true;

    public Conditioner(String deviceName, ID<Integer> deviceId, States state) {
        super(deviceName, deviceId, state);

        this.name = deviceName;
        this.id = deviceId;
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ID<Integer> getID() {
        return id;
    }

    @Override
    public void run() {
        try {
            while (check) {
                if (Manager.getTemp() >= Manager.getMaxTemp() || Manager.getTemp() <= Manager.getMinTemp()) {
                    state = States.On;
                    temperature = 17;
                    Manager.setTemp(temperature);
                    System.out.println(message());
                } else {
                    state = States.Off;
                }
                Thread.sleep(2500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String message() {
        return "Кондидионер включен!!!";
    }
}
