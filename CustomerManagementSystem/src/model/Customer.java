package model;
public class Customer {
    // bean or pojo or model or entity class
    // FYI - lombok
    private String email;
    private String custname;
    private String city;
    private String phone;
    private String password;

    public Customer(){
        //todo auto generated stub
    }
    public Customer(String email, String custname, String city, String phone, String password){
        super();
        this.email = email;
        this.city = city;
        this.custname = custname;
        this.password = password;
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String paassword) {
        this.password = paassword;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "email='" + email + '\'' +
                ", custname='" + custname + '\'' +
                ", city='" + city + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
