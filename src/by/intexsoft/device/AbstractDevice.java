package by.intexsoft.device;

import by.intexsoft.personalId.ID;
import by.intexsoft.state.States;

/**
 * Created by Admin on 19.07.2015.
 */
public abstract class AbstractDevice {
    public String name;
    public ID<Integer> id;
    public States state = States.Off;

    AbstractDevice(String deviceName, ID<Integer> deviceId, States state) {
        name = deviceName;
        id = deviceId;
        this.state = state;
    }
}
