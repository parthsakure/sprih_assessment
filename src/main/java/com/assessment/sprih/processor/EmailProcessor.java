package com.assessment.sprih.processor;


public class EmailProcessor extends EventProcessor{
    @Override
    public void execute() {
        try {
            System.out.println("Email Processing started...");
            Thread.sleep(5000);
            System.out.println("Email Processing done!");
        } catch (InterruptedException e){
           e.printStackTrace();
        }
    }
}
