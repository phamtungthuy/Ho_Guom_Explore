package org.meicode.ho_guom_explore.ManageInterface.PositionManagement;

public class PositionDataClass {
    private String dataTitle;
    private String dataDescription;
    private String dataAddress;
    private String key;
    private String dataImage;
    private String dataAudio;

    public PositionDataClass(String dataTitle, String dataDescription, String dataAddress, String dataImage, String dataAudio) {
        this.dataTitle = dataTitle;
        this.dataDescription = dataDescription;
        this.dataAddress = dataAddress;
        this.dataImage = dataImage;
        this.dataAudio = dataAudio;
    }

    public PositionDataClass() {

    }

    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataDescription() {
        return dataDescription;
    }

    public String getDataAddress() {
        return dataAddress;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDataImage() {
        return dataImage;
    }

    public String getDataAudio() {
        return dataAudio;
    }
}
