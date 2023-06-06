package com.mapping.Mapping.utils;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:MessageAndCodes.properties")
@Getter
@Setter
public class ValidationResponseCode {
    //common Success Code
    @Value("${code.success.common}")
    private String commonSuccessCode;

    //Address validation code
    @Value("${code.validation.Address.AlreadyExists}")
    private String addressAlReadyExits;
    @Value("${code.validation.Address.notExists}")
    private String addressNotExists;

    //Address validation and Success message
    @Value("${message.success.safe.Address}")
    private String addressSaveSuccessMessage;
    @Value("${message.validation.Address.alreadyExits}")
    private String addressAllReadyExistsMessage;
    @Value("${message.validation.address.notExists}")
    private String addressNotExistsMessage;
    @Value("${message.success.getAll.Address}")
    private String getAddressSuccessMessage;
    @Value("${message.validation.getAll.Address}")
    private String addressNotFound;
    @Value("${message.success.delete.Address}")
    private String addressDeleteSuccessMessage;


    //Employee validation code
    @Value("${code.validation.employee.AlreadyExists}")
    private String employeeAlReadyExits;
    @Value("${code.validation.employee.notExists}")
    private String employeeNotExists;

    //Employee validation and Success message
    @Value("${message.success.safe.employee}")
    private String employeeSaveSuccessMessage;
    @Value("${message.validation.employee.alreadyExits}")
    private String employeeAllReadyExistsMessage;
    @Value("${message.validation.employee.notExists}")
    private String employeeNotExistsMessage;
    @Value("${message.success.getAll.employee}")
    private String employeeGetAllSuccessMessage;
    @Value("${message.success.get.employee}")
    private String employeeGetSuccessMessage;
    @Value("${message.success.delete.employee}")
    private String employeeDeleteSuccessMessage;

    //Employee validation code
    @Value("${code.validation.order.AlreadyExists}")
    private String orderAlReadyExits;
    @Value("${code.validation.order.notExists}")
    private String orderNotExists;

    //Order validation and Success message
    @Value("${message.success.safe.order}")
    private String orderSaveSuccessMessage;
    @Value("${message.validation.order.alreadyExits}")
    private String orderAllReadyExistsMessage;
    @Value("${message.validation.order.notExists}")
    private String orderNotExistsMessage;
    @Value("${message.success.getALl.order}")
    private String orderGetALlSuccessMessage;
    @Value("${message.success.get.order}")
    private String orderGetSuccessMessage;
    @Value("${message.success.delete.order}")
    private String orderDelteSuccessMessage;

    //Item validation code
    @Value("${code.validation.item.AlreadyExists}")
    private String itemAlReadyExits;
    @Value("${code.validation.item.notExists}")
    private String itemNotExists;

    //item validation and Success message
    @Value("${message.success.safe.item}")
    private String itemSaveSuccessMessage;
    @Value("${message.validation.item.alreadyExits}")
    private String itemAllReadyExistsMessage;
    @Value("${message.validation.item.notExists}")
    private String itemNotExistsMessage;
    @Value("${message.success.getAll.item}")
    private String getAllItemSuccessMessage;
    @Value("${message.success.get.item}")
    private String getItemSuccessMessage;
    @Value("${message.success.delete.item}")
    private String deleteItemSuccessMessage;

    //Customer validation code
    @Value("${code.validation.customer.AlreadyExists}")
    private String customerAlReadyExits;
    @Value("${code.validation.customer.notExists}")
    private String customerNotExists;

    //Customer validation and Success message
    @Value("${message.success.safe.customer}")
    private String customerSaveSuccessMessage;
    @Value("${message.validation.customer.alreadyExits}")
    private String customerAllReadyExistsMessage;
    @Value("${message.validation.customer.notExists}")
    private String customerNotExistsMessage;
    @Value("${message.success.getAll.customer}")
    private String customerGetAllSuccessMessage;
    @Value("${message.success.get.customer}")
    private String customerGetSuccessMessage;
    @Value("${message.success.delete.customer}")
    private String customerDeleteSuccessMessage;

}


