package org.meicode.ho_guom_explore.ManageInterface.ServiceManagement;

public class ServiceDataClass {
    private String dataTitle;
    private String dataDescription;
    private String dataAddress;
    private String dataImage;
    private String dataPhoneNumber;
    private String dataWebsite;
    private String dataEmail;
    private String key;

    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataDescription() {
        return dataDescription;
    }

    public String getDataAddress() {
        return dataAddress;
    }

    public String getDataImage() {
        return dataImage;
    }

    public String getDataPhoneNumber() {
        return dataPhoneNumber;
    }

    public String getDataWebsite() {
        return dataWebsite;
    }

    public String getDataEmail() {
        return dataEmail;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ServiceDataClass(String dataTitle, String dataDescription, String dataAddress, String dataImage, String dataPhoneNumber, String dataWebsite, String dataEmail) {
        this.dataTitle = dataTitle;
        this.dataDescription = dataDescription;
        this.dataAddress = dataAddress;
        this.dataImage = dataImage;
        this.dataPhoneNumber = dataPhoneNumber;
        this.dataWebsite = dataWebsite;
        this.dataEmail = dataEmail;
    }

    public ServiceDataClass() {

    }
}
