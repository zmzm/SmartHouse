package by.intexsoft.enviroment;

/**
 * Created by Admin on 21.07.2015.
 */
public interface Environment {
    public Integer getTime();

    public Integer getMinTime();

    public Integer getMaxTime();

    public void setTime(Integer t);

    public Integer getTemp();

    public void setTemp(Integer t);

    public Integer getMinTemp();

    public Integer getMaxTemp();
}
