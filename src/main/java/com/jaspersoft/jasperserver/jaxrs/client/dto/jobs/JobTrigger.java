package com.jaspersoft.jasperserver.jaxrs.client.dto.jobs;

public class JobTrigger {

    private Long id;
    private Integer version;
    private String timezone;
    private String calendarName;
    private int startType;
    private String startDate;
    private String endDate;
    private Integer misfireInstruction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getCalendarName() {
        return calendarName;
    }

    public void setCalendarName(String calendarName) {
        this.calendarName = calendarName;
    }

    public int getStartType() {
        return startType;
    }

    public void setStartType(int startType) {
        this.startType = startType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getMisfireInstruction() {
        return misfireInstruction;
    }

    public void setMisfireInstruction(Integer misfireInstruction) {
        this.misfireInstruction = misfireInstruction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof JobTrigger)) return false;

        JobTrigger trigger = (JobTrigger) o;

        if (startType != trigger.startType) return false;
        if (calendarName != null ? !calendarName.equals(trigger.calendarName) : trigger.calendarName != null)
            return false;
        if (endDate != null ? !endDate.equals(trigger.endDate) : trigger.endDate != null) return false;
        if (id != null ? !id.equals(trigger.id) : trigger.id != null) return false;
        if (misfireInstruction != null ? !misfireInstruction.equals(trigger.misfireInstruction) : trigger.misfireInstruction != null)
            return false;
        if (startDate != null ? !startDate.equals(trigger.startDate) : trigger.startDate != null) return false;
        if (timezone != null ? !timezone.equals(trigger.timezone) : trigger.timezone != null) return false;
        if (version != null ? !version.equals(trigger.version) : trigger.version != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (timezone != null ? timezone.hashCode() : 0);
        result = 31 * result + (calendarName != null ? calendarName.hashCode() : 0);
        result = 31 * result + startType;
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + (misfireInstruction != null ? misfireInstruction.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "JobTrigger{" +
                "id=" + id +
                ", version=" + version +
                ", timezone='" + timezone + '\'' +
                ", calendarName='" + calendarName + '\'' +
                ", startType=" + startType +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", misfireInstruction=" + misfireInstruction +
                '}';
    }
}
