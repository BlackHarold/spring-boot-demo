package com.example.soap.model;

public class OperationResponse {

    private Integer resultNumber;

    public OperationResponse(Integer resultNumber) {
        this.resultNumber = resultNumber;
    }

    public Integer getResultNumber() {
        return resultNumber;
    }

    public void setResultNumber(Integer resultNumber) {
        this.resultNumber = resultNumber;
    }
}
