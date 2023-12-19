package com.javatechie.jooq.service;

import com.javatechie.jooq.model.Tables;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javatechie.jooq.model.tables.pojos.*;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private DSLContext dslContext;

    //write a method to add a Customer and get all the customers

    public void insertCustomer(Customer customer) {

        dslContext.insertInto(Tables.CUSTOMER,
                Tables.CUSTOMER.REGISTERED,
                Tables.CUSTOMER.EMAIL_ADDRESS,
                Tables.CUSTOMER.TITLE,
                Tables.CUSTOMER.FIRST_NAME,
                Tables.CUSTOMER.LAST_NAME,
                Tables.CUSTOMER.ADDRESS_LINE1,
                Tables.CUSTOMER.ADDRESS_LINE2,
                Tables.CUSTOMER.CITY,
                Tables.CUSTOMER.POSTCODE,
                Tables.CUSTOMER.PHONE_NUMBER)
                .values(customer.getRegistered(),
                        customer.getEmailAddress(),
                        customer.getTitle(),
                        customer.getFirstName(),
                        customer.getLastName(),
                        customer.getAddressLine1(),
                        customer.getAddressLine2(),
                        customer.getCity(),
                        customer.getPostcode(),
                        customer.getPhoneNumber()).execute();

    }

    public List<Customer> getCustomers() {
        return dslContext.selectFrom(Tables.CUSTOMER)
                .fetchInto(Customer.class);
    }

}
