package models;

public class Customer {

    private int cid;
    private String CustomerName;
    private String CustomerContact;
    private String CustomerEmail;
    private String CustomerPassword;
    private String CustomerAddress;
    private String CustomerNationalid;
    private String CustomerGender;
    private String CustomerDOB;
    private String CustomerPaymentmethod;
    public int getCid() {
        return cid;
    }
    public void setCid(int cid) {
        this.cid = cid;
    }
    public String getCustomerName() {
        return CustomerName;
    }
    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }
    public String getCustomerContact() {
        return CustomerContact;
    }
    public void setCustomerContact(String customerContact) {
        CustomerContact = customerContact;
    }
    public String getCustomerEmail() {
        return CustomerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        CustomerEmail = customerEmail;
    }
    public String getCustomerPassword() {
        return CustomerPassword;
    }
    public void setCustomerPassword(String customerPassword) {
        CustomerPassword = customerPassword;
    }
    public String getCustomerAddress() {
        return CustomerAddress;
    }
    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }
    public String getCustomerNationalid() {
        return CustomerNationalid;
    }
    public void setCustomerNationalid(String customerNationalid) {
        CustomerNationalid = customerNationalid;
    }
    public String getCustomerGender() {
        return CustomerGender;
    }
    public void setCustomerGender(String customerGender) {
        CustomerGender = customerGender;
    }
    public String getCustomerDOB() {
        return CustomerDOB;
    }
    public void setCustomerDOB(String customerDOB) {
        CustomerDOB = customerDOB;
    }
    public String getCustomerPaymentmethod() {
        return CustomerPaymentmethod;
    }
    public void setCustomerPaymentmethod(String customerPaymentmethod) {
        CustomerPaymentmethod = customerPaymentmethod;
    }

    public String toString() {
        return this.cid+","+this.CustomerName+","+this.CustomerPassword;
    }
}