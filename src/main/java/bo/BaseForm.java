package bo;

public class BaseForm {
    private String vmClass;
    private String instanceType;
    private String localSSD;

    public String getVmClass() {
        return vmClass;
    }

    public void setVmClass(String vmClass) {
        this.vmClass = vmClass;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public String getLocalSSD() {
        return localSSD;
    }

    public void setLocalSSD(String localSSD) {
        this.localSSD = localSSD;
    }
}
