package by.intexsoft.device;

import by.intexsoft.personalId.IPersonalID;
import by.intexsoft.state.State;

/**
 * Created by Admin on 19.07.2015.
 */
public class Conditioner extends AbstractDevice {
    private String name;
    private IPersonalID<Integer> id;
    private int temperature;
    private State state;

    public Conditioner(String deviceName, IPersonalID<Integer> deviceId, State state) {
        super(deviceName, deviceId, state);

        this.name = deviceName;
        this.id = deviceId;
        this.state = state;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public IPersonalID<Integer> getID(){
        return id;
    }

    public void setId(IPersonalID<Integer> id){
        this.id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
