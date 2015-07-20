package by.intexsoft.personalId;

/**
 * Created by Admin on 19.07.2015.
 */
public class PersonalID implements ID<Integer> {
    private int id;

    public PersonalID(int id){
        this.id = id;
    }

    @Override
    public Integer value() {
        return id;
    }
}
