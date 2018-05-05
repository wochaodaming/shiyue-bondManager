package com.shiyue.bm.consumer.module;

public class InstantMessage {
    private String number;
    private ImStatus addStatus;

    public String getNumber() {
        return number;
    }

    public InstantMessage setNumber(String number) {
        this.number = number;
        return this;
    }

    public ImStatus getAddStatus() {
        return addStatus;
    }

    public InstantMessage setAddStatus(ImStatus addStatus) {
        this.addStatus = addStatus;
        return this;
    }
}
