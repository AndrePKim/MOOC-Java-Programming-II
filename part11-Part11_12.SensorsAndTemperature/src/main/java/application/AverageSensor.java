
package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor{
    private ArrayList<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }
    
    public void addSensor(Sensor toAdd) {
        this.sensors.add(toAdd);
    }
    
    public boolean isOn() {
        for (int i=0; i<this.sensors.size(); i++) {
            if (!this.sensors.get(i).isOn()) {
                return false;
            }
        }
        return true;
    }
    public void setOn() {
        for (int i=0; i<this.sensors.size(); i++) {
            this.sensors.get(i).setOn();
        }
    }
    public void setOff() {
        for (int i=0; i<this.sensors.size(); i++) {
            this.sensors.get(i).setOff();
        }
    }
    public int read() {
        if (this.isOn()==false || this.sensors.isEmpty()) {
            throw new IllegalStateException("Sensors not on or is empty");
        }
        int sum = 0;
        for (int i=0; i<this.sensors.size(); i++) {
            sum += this.sensors.get(i).read();
        }
        this.readings.add(sum/this.sensors.size());
        return sum/this.sensors.size();
    }
    
    public List<Integer> readings() {
        return this.readings;
    }
}
