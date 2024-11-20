package com.lt.spring.labs.controllers.dto;

public class CreateUserDto {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String countryOfResidence;
    private String governmentIdentifier;
    private Long balanceHeldOnAccount;
    private String identifierType;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public String getGovernmentIdentifier() {
        return governmentIdentifier;
    }

    public void setGovernmentIdentifier(String governmentIdentifier) {
        this.governmentIdentifier = governmentIdentifier;
    }

    public Long getBalanceHeldOnAccount() {
        return balanceHeldOnAccount;
    }

    public void setBalanceHeldOnAccount(Long balanceHeldOnAccount) {
        this.balanceHeldOnAccount = balanceHeldOnAccount;
    }

    public String getIdentifierType() {
        return identifierType;
    }

    public void setIdentifierType(String identifierType) {
        this.identifierType = identifierType;
    }
}
