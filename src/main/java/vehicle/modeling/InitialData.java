package vehicle.modeling;

/**
 * User: Atiqur Rahman
 * Date: 6/15/12 9:07 PM
 */
public class InitialData {
    Double vehicleMass;
    Double vehicleWheelBase;
    Double vehicleTrackWidth;
    Double frontAxleCog;
    Double rearAxleCog;
    Double cogHeight;
    Double aerodynamicForceHeight;
    Double momentOfInertia;
    Double frontalAreaOfAirdrag;
    String bodyShapeType;

    public InitialData() {
        this.vehicleMass = 0.0;
        this.vehicleWheelBase = 0.0;
        this.vehicleTrackWidth = 0.0;
        this.frontAxleCog = 0.0;
        this.rearAxleCog = 0.0;
        this.cogHeight = 0.0;
        this.aerodynamicForceHeight = 0.0;
        this.momentOfInertia = 0.0;
        this.frontalAreaOfAirdrag = 0.0;
        this.bodyShapeType = "";

    }

    public InitialData(String vehicleMass, String vehicleWheelBase, String vehicleTrackWidth, String frontAxleCog, String rearAxleCog, String cogHeight, String aerodynamicForceHeight, String momentOfInertia, String frontalAreaOfAirdrag, String bodyShapeType) {
        this.vehicleMass = Utils.isNotEmpty(vehicleMass) ? Double.valueOf(vehicleMass) : 0.0;
        this.vehicleWheelBase = Utils.isNotEmpty(vehicleWheelBase) ? Double.valueOf(vehicleWheelBase) : 0.0;
        this.vehicleTrackWidth = Utils.isNotEmpty(vehicleTrackWidth) ? Double.valueOf(vehicleTrackWidth) : 0.0;
        this.frontAxleCog = Utils.isNotEmpty(frontAxleCog) ? Double.valueOf(frontAxleCog) : 0.0;
        this.rearAxleCog = Utils.isNotEmpty(rearAxleCog) ? Double.valueOf(rearAxleCog) : 0.0;
        this.cogHeight = Utils.isNotEmpty(cogHeight) ? Double.valueOf(cogHeight) : 0.0;
        this.aerodynamicForceHeight = Utils.isNotEmpty(aerodynamicForceHeight) ? Double.valueOf(aerodynamicForceHeight) : 0.0;
        this.momentOfInertia = Utils.isNotEmpty(momentOfInertia) ? Double.valueOf(momentOfInertia) : 0.0;
        this.frontalAreaOfAirdrag = Utils.isNotEmpty(frontalAreaOfAirdrag) ? Double.valueOf(frontalAreaOfAirdrag) : 0.0;
        this.bodyShapeType = bodyShapeType;
    }

    public double getVehicleMass() {
        return vehicleMass;
    }

    public void setVehicleMass(double vehicleMass) {
        this.vehicleMass = vehicleMass;
    }

    public double getVehicleWheelBase() {
        return vehicleWheelBase;
    }

    public void setVehicleWheelBase(double vehicleWheelBase) {
        this.vehicleWheelBase = vehicleWheelBase;
    }

    public double getVehicleTrackWidth() {
        return vehicleTrackWidth;
    }

    public void setVehicleTrackWidth(double vehicleTrackWidth) {
        this.vehicleTrackWidth = vehicleTrackWidth;
    }

    public double getFrontAxleCog() {
        return frontAxleCog;
    }

    public void setFrontAxleCog(double frontAxleCog) {
        this.frontAxleCog = frontAxleCog;
    }

    public double getRearAxleCog() {
        return rearAxleCog;
    }

    public void setRearAxleCog(double rearAxleCog) {
        this.rearAxleCog = rearAxleCog;
    }

    public double getCogHeight() {
        return cogHeight;
    }

    public void setCogHeight(double cogHeight) {
        this.cogHeight = cogHeight;
    }

    public double getAerodynamicForceHeight() {
        return aerodynamicForceHeight;
    }

    public void setAerodynamicForceHeight(double aerodynamicForceHeight) {
        this.aerodynamicForceHeight = aerodynamicForceHeight;
    }

    public double getMomentOfInertia() {
        return momentOfInertia;
    }

    public void setMomentOfInertia(double momentOfInertia) {
        this.momentOfInertia = momentOfInertia;
    }

    public double getFrontalAreaOfAirdrag() {
        return frontalAreaOfAirdrag;
    }

    public void setFrontalAreaOfAirdrag(double frontalAreaOfAirdrag) {
        this.frontalAreaOfAirdrag = frontalAreaOfAirdrag;
    }

    public String getBodyShapeType() {
        return bodyShapeType;
    }

    public void setBodyShapeType(String bodyShapeType) {
        this.bodyShapeType = bodyShapeType;
    }

    @Override
    public String toString() {
        String data = "";
        data += "\nVehicle Mass: " + vehicleMass;
        data += "\nVehicle Wheel Base: " + vehicleWheelBase;
        data += "\nVehicle Track Width: " + vehicleTrackWidth;
        data += "\nFront axle of COG: " + frontAxleCog;
        data += "\nRear axle of COG: " + rearAxleCog;
        data += "\nHeight of COG: " + cogHeight;
        data += "\nHeight of Aerodynamic Force: " + aerodynamicForceHeight;
        data += "\nMoment of Inertia of body: " + momentOfInertia;
        data += "\nFrontal area of airbag: " + frontalAreaOfAirdrag;
        data += "\nBody shape type: " + bodyShapeType;

        return data;
    }


}
