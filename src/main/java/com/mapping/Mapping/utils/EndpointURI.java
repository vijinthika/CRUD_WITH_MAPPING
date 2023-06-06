package com.mapping.Mapping.utils;

public class EndpointURI {
    private static final String BASE_API_PATH="/api/v1/";
    private static final String ID="/{id}";

    public static final String ADDRESS=BASE_API_PATH+"address";
    public static final String ADDRESS_BY_ID=ADDRESS+ID;
    public static final String EMPLOYEE=BASE_API_PATH+"employee";
    public static final String EMPLOYEE_BY_ID=EMPLOYEE+ID;
    public static final String ORDER=BASE_API_PATH+"order";
    public static final String ORDER_BY_ID=ORDER+ID;
    public static final String ITEM=BASE_API_PATH+"item";
    public static final String ITEM_BY_ID=ITEM+ID;
    public static final String CUSTOMER=BASE_API_PATH+"customer";
    public static final String CUSTOMER_BY_ID=CUSTOMER+ID;



}
