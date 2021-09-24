package org.redhat.rhpam.tests;

import java.io.Serializable;
import java.time.ZoneId;

public class NotificationConfiguration implements Serializable {

    private String numberOfRepetitions = "1";
    private String initialDelayValue;
    private String initialDelayUnit;
    private String subsequentDelayValue;
    private String subsequentDelayUnit;
    private String isoExpression;
    private String taskName;
    private String processId;
    private String lookupKey;
    private ZoneId zoneId;

    public String getNumberOfRepetitions() {
        return numberOfRepetitions;
    }

    public void setNumberOfRepetitions(String numberOfRepetitions) {
        this.numberOfRepetitions = numberOfRepetitions;
    }

    public String getInitialDelayValue() {
        return initialDelayValue;
    }

    public void setInitialDelayValue(String initialDelayValue) {
        this.initialDelayValue = initialDelayValue;
    }

    public String getInitialDelayUnit() {
        return initialDelayUnit;
    }

    public void setInitialDelayUnit(String initialDelayUnit) {
        this.initialDelayUnit = initialDelayUnit;
    }

    public String getSubsequentDelayValue() {
        return subsequentDelayValue;
    }

    public void setSubsequentDelayValue(String subsequentDelayValue) {
        this.subsequentDelayValue = subsequentDelayValue;
    }

    public String getSubsequentDelayUnit() {
        return subsequentDelayUnit;
    }

    public void setSubsequentDelayUnit(String subsequentDelayUnit) {
        this.subsequentDelayUnit = subsequentDelayUnit;
    }

    public String getIsoExpression() {
        return isoExpression;
    }

    public void setIsoExpression(String isoExpression) {
        this.isoExpression = isoExpression;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public void setZoneId(ZoneId zoneId) {
        this.zoneId = zoneId;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public String getLookupKey() {
        return lookupKey;
    }

    public void setLookupKey(String lookupKey) {
        this.lookupKey = lookupKey;
    }

    @Override
    public String toString() {
        return "NotificationConfiguration{" +
                "numberOfRepetitions='" + numberOfRepetitions + '\'' +
                ", initialDelayValue='" + initialDelayValue + '\'' +
                ", initialDelayUnit='" + initialDelayUnit + '\'' +
                ", subsequentDelayValue='" + subsequentDelayValue + '\'' +
                ", subsequentDelayUnit='" + subsequentDelayUnit + '\'' +
                ", isoExpression='" + isoExpression + '\'' +
                ", taskName='" + taskName + '\'' +
                ", processId='" + processId + '\'' +
                ", lookupKey='" + lookupKey + '\'' +
                ", zoneId=" + zoneId +
                '}';
    }
}
