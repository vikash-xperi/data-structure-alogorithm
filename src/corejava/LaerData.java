package corejava;

import java.util.Date;

public class LaerData {
    private Date laerStartDt;
    private Date laerEndDt;
    private Date entitlementStartDt;
    private Date entitlementEndDt;
    private Date availabilityWindowStartDt;

    public Date getLaerStartDt() {
        return laerStartDt;
    }

    @Override
    public String toString() {
        return "LaerData{" +
                "laerStartDt=" + laerStartDt +
                ", laerEndDt=" + laerEndDt +
                ", entitlementStartDt=" + entitlementStartDt +
                ", entitlementEndDt=" + entitlementEndDt +
                ", availabilityWindowStartDt=" + availabilityWindowStartDt +
                ", availabilityWindowEndDt=" + availabilityWindowEndDt +
                '}';
    }

    public void setLaerStartDt(Date laerStartDt) {
        this.laerStartDt = laerStartDt;
    }

    public Date getLaerEndDt() {
        return laerEndDt;
    }

    public void setLaerEndDt(Date laerEndDt) {
        this.laerEndDt = laerEndDt;
    }

    public Date getEntitlementStartDt() {
        return entitlementStartDt;
    }

    public void setEntitlementStartDt(Date entitlementStartDt) {
        this.entitlementStartDt = entitlementStartDt;
    }

    public Date getEntitlementEndDt() {
        return entitlementEndDt;
    }

    public void setEntitlementEndDt(Date entitlementEndDt) {
        this.entitlementEndDt = entitlementEndDt;
    }

    public Date getAvailabilityWindowStartDt() {
        return availabilityWindowStartDt;
    }

    public void setAvailabilityWindowStartDt(Date availabilityWindowStartDt) {
        this.availabilityWindowStartDt = availabilityWindowStartDt;
    }

    public Date getAvailabilityWindowEndDt() {
        return availabilityWindowEndDt;
    }

    public void setAvailabilityWindowEndDt(Date availabilityWindowEndDt) {
        this.availabilityWindowEndDt = availabilityWindowEndDt;
    }

    private Date availabilityWindowEndDt;
}
