package edu.mum.cs544.paycheck.Domain;

public class Result {
    private String returnCode; //Success or Failed;
    private String description;

    public Result(String code, String desc) {
        this.returnCode = code;
        this.description = desc;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
