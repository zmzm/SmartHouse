package by.intexsoft.device;

import by.intexsoft.personalId.PersonalID;
import by.intexsoft.state.State;

/**
 * Created by Admin on 19.07.2015.
 */
public class Server extends AbstractDevice {
    private Integer id = 1;

    public Server(String deviceName) {
        super(deviceName, new PersonalID(0), State.On);
    }

    public PersonalID generateID() {
        return new PersonalID(id++);
    }
}
