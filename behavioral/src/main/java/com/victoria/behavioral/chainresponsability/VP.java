package com.victoria.behavioral.chainresponsability;

public class VP extends Handler {
    @Override
    public void handleRequest(Request request) {
        if (request.requestType() == RequestType.PURCHASE) {
            if (request.amount() < 1500) {
                System.out.println("VPs can approve purchases below 1500");
            } else {
                successor.handleRequest(request);
            }

        }
    }
}
