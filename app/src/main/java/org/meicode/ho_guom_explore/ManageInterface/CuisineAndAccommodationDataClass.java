package org.meicode.ho_guom_explore.ManageInterface;

public class CuisineAndAccommodationDataClass {
    private String dataTitle;
    private String dataDescription;
    private String dataAddress;
    private String dataImage;
    private String dataPhoneNumber;
    private String dataWebsite;
    private String dataEmail;
    private String key;
    private String fieldName;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
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

    public CuisineAndAccommodationDataClass(String dataTitle, String dataDescription, String dataAddress, String dataImage, String dataPhoneNumber, String dataWebsite, String dataEmail) {
        this.dataTitle = dataTitle;
        this.dataDescription = dataDescription;
        this.dataAddress = dataAddress;
        this.dataImage = dataImage;
        this.dataPhoneNumber = dataPhoneNumber;
        this.dataWebsite = dataWebsite;
        this.dataEmail = dataEmail;
    }

    public CuisineAndAccommodationDataClass() {

    }
}
