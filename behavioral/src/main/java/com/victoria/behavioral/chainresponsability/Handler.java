package com.victoria.behavioral.chainresponsability;

public abstract class Handler {
    protected Handler successor;

    public abstract void handleRequest(Request request);

    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }
}
