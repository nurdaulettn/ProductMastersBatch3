package org.example.model;

public class StudentAttendanceDto {
    private String name;
    private String groupName;
    private boolean isAttended;

    public StudentAttendanceDto() {
    }

    public StudentAttendanceDto(String name, String groupName, boolean isAttended) {
        this.name = name;
        this.groupName = groupName;
        this.isAttended = isAttended;
    }

    public String getName() {
        return name;
    }

    public String getGroupName() {
        return groupName;
    }

    public boolean isAttended() {
        return isAttended;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setAttended(boolean attended) {
        isAttended = attended;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private String groupName;
        private boolean isAttended;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder groupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        public Builder isAttended(boolean isAttended) {
            this.isAttended = isAttended;
            return this;
        }

        public StudentAttendanceDto build() {
            return new StudentAttendanceDto(name, groupName, isAttended);
        }
    }
}
