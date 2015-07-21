package by.intexsoft.device;

import by.intexsoft.manager.Manager;
import by.intexsoft.messenger.Messenger;
import by.intexsoft.personalId.ID;
import by.intexsoft.state.States;

/**
 * Created by Admin on 19.07.2015.
 */
public class Light extends AbstractDevice implements Runnable, Messenger {
    private String name;
    private ID id;
    private States state;
    private boolean check = true;

    public Light(String deviceName, ID deviceId, States state) {
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

    public States getState() {
        return state;
    }

    public void setState(States state) {
        this.state = state;
    }

    @Override
    public void run() {
        try {
            while (check) {
                if ((Manager.environmentData.getTime() >= 1 && Manager.environmentData.getTime() <= 19)) {
                    this.state = States.Off;
                } else {
                    this.state = States.On;
                    System.out.println(message());
                }
                Thread.sleep(2500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String message() {
        return "Свет включен!!!";
    }
}

