package by.intexsoft.device;

import by.intexsoft.personalId.IPersonalID;
import by.intexsoft.state.State;

/**
 * Created by Admin on 19.07.2015.
 */
public class Light extends AbstractDevice {
    private String name;
    private IPersonalID<Integer> id;
    private State state;

    public Light(String deviceName, IPersonalID<Integer> deviceId, State state) {
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

    public IPersonalID<Integer> getID() {
        return id;
    }

    public void setId(IPersonalID<Integer> id) {
        this.id = id;
    }

    public String getState(){
        if(state.equals(State.On)){
            return "Кто-то подошел к двери. Свет включен!";
        }
        else
            return "Кто-то свалил. Свет выключен!";
    }

    public void setState(State state){
        this.state = state;
    }

}

