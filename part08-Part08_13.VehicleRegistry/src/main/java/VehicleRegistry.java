import java.util.HashMap;
import java.util.ArrayList;

public class VehicleRegistry {
    private HashMap<LicensePlate,String> vehicle;
    
    public VehicleRegistry() {
        this.vehicle = new HashMap<>();
    }
    
    public boolean add(LicensePlate licensePlate, String owner) {
        if (this.vehicle.containsKey(licensePlate)) {
            return false;
        }
        this.vehicle.put(licensePlate, owner);
        return true;
    }
    
    public String get(LicensePlate licensePlate) {
        if (this.vehicle.containsKey(licensePlate)) {
            return this.vehicle.get(licensePlate);
        }
        return null;
    }
    
    public boolean remove(LicensePlate licensePlate) {
        if (this.vehicle.containsKey(licensePlate)) {
            this.vehicle.remove(licensePlate);
            return true;
        }
        return false;
    }
    
    public void printLicensePlates() {
        for (LicensePlate license: this.vehicle.keySet()) {
            System.out.println(license);
        }
    }
    
    public void printOwners() {
        ArrayList<String> owners = new ArrayList<>();
        for (LicensePlate license: this.vehicle.keySet()) {
            if (owners.contains(this.vehicle.get(license))) {
                continue;
            }
            owners.add(this.vehicle.get(license));
            System.out.println(this.vehicle.get(license));
        }
    }
}
