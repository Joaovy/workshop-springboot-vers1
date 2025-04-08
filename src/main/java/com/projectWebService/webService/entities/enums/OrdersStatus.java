package com.projectWebService.webService.entities.enums;

public enum OrdersStatus {

    WAITING_PAYMENT(1), // é como se fosse 0
    PAID(2), // e assim por diante 1
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrdersStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static OrdersStatus valueOf(int code){

        for(OrdersStatus value : OrdersStatus.values()){
            if(value.getCode() == code){
                return value;
            }

        }
     throw new IllegalArgumentException("Codigo invalido");
    }
}
