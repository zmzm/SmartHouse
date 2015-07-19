package by.intexsoft.device;

import by.intexsoft.personalId.IPersonalID;
import by.intexsoft.state.State;

/**
 * Created by Admin on 19.07.2015.
 */
public abstract class AbstractDevice {
    public String name;
    public IPersonalID<Integer> id;
    public State state = State.Off;

    AbstractDevice(String deviceName, IPersonalID<Integer> deviceId, State state) {
        name = deviceName;
        id = deviceId;
        this.state = state;
    }
}
