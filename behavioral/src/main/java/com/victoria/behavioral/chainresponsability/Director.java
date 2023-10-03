package com.victoria.behavioral.chainresponsability;

public class Director extends Handler {

    @Override
    public void handleRequest(Request request) {
        if (request.requestType() == RequestType.CONFERENCE) {
            System.out.println("Directors can approve conferences ");
        }
        else {
            successor.handleRequest(request);
        }
    }
}
