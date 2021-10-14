package com.spring.DTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AddressBookDTO {
    public int id;
    public String firstName;
    public String lastName;
    public long mobileNumber;
    public String street;
    public String village;
    public String city;
    public int zipCode;

}
