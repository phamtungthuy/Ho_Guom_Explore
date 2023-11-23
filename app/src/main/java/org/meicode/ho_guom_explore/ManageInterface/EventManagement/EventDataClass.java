package org.meicode.ho_guom_explore.ManageInterface.EventManagement;

public class EventDataClass {
    private String dataTitle;
    private String dataDescription;
    private String dataImage;
    private String dataStartDate;
    private String dataEndDate;
    private String dataLocation;
    private String key;
    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataDescription() {
        return dataDescription;
    }

    public String getDataImage() {
        return dataImage;
    }

    public String getDataStartDate() {
        return dataStartDate;
    }

    public String getDataEndDate() {
        return dataEndDate;
    }

    public String getDataLocation() {
        return dataLocation;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public EventDataClass(String dataTitle, String dataDescription, String dataImage, String dataStartDate, String dataEndDate, String dataLocation) {
        this.dataTitle = dataTitle;
        this.dataDescription = dataDescription;
        this.dataImage = dataImage;
        this.dataStartDate = dataStartDate;
        this.dataEndDate = dataEndDate;
        this.dataLocation = dataLocation;
    }

    public EventDataClass() {

    }
}
