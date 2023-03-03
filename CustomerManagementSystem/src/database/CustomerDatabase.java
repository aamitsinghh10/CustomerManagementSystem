package database;

import java.util.ArrayList;
import java.util.List;

import model.Customer;

public class CustomerDatabase {

    private List<Customer> customers = new ArrayList<>();

    public CustomerDatabase()
    {
        customers.add(new Customer("a@a.c","aa","Pune","1111111111","aa"));
        customers.add(new Customer("b@a.c","bb","Hyderabad","2222222222","bb"));
        customers.add(new Customer("c@a.c","cc","Pune","3333333333","cc"));
    }

    public List<Customer> getAllCustomers()
    {
        return this.customers;
    }

    public boolean insertCustomer(Customer customer) throws Exception
    {
        for(Customer cust:customers)
        {
            if(cust.getEmail().equals(customer.getEmail()))
                throw new Exception("Customer cannot be registered as email already exists");
        }

        customers.add(customer);
        return true;
    }
    public Customer getCustomerByEmail(String email)
    {
        Customer customer = null;

        for(Customer cust : customers)
        {
            if(cust.getEmail().equals(email))
            {
                customer = cust;
                break;
            }
        }
        return customer;
    }
    public boolean login(String email, String password)
    {
        for(Customer c : customers)
        {
            if(c.getEmail().equals(email))
            {
                if(c.getPassword().equals(password))
                    return true;
            }
        }
        return false;
    }
    //change password
    public void changePassword(String email, String newPassword) throws Exception
    {
        for(Customer c: customers)
        {
            if(c.getEmail().equals(email))
            {
                c.setPassword(newPassword);
                break;
            }
            else{
                throw new Exception("Email is not correct so unable to change password");
            }
        }
    }
    //update Name
    public void updateName(String email, String newName) throws Exception
    {
        for(Customer c: customers)
        {
            if(c.getEmail().equals(email))
            {
                c.setCustname(newName);
                break;
            }
            else{
                throw new Exception("Email is not correct so unable to change Name");
            }
        }
    }
    //update city
    public void updateCity(String email, String newCity) throws Exception
    {
        for(Customer c: customers)
        {
            if(c.getEmail().equals(email))
            {
                c.setCity(newCity);
                break;
            }
            else{
                throw new Exception("Email is not correct so unable to change City");
            }
        }
    }
    //update phone
    public void updatePhone(String email, String newPhone) throws Exception
    {
        for(Customer c: customers)
        {
            if(c.getEmail().equals(email))
            {
                c.setPhone(newPhone);
                break;
            }
            else{
                throw new Exception("Email is not correct so unable to change Phone");
            }
        }
    }

}