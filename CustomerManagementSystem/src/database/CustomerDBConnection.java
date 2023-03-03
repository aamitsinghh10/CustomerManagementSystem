package database;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDBConnection {
    Connection conn = DBConnection.getConnection();

    public List<Customer> getAllCustomers() throws Exception
    {
        String sql = "select * from customer";
        //1. Get DB Connection
        //2. create Statements
        List<Customer> customers = new ArrayList<>();

        try{
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                Customer c1 = new Customer();
                c1.setEmail(rs.getString(1));
                c1.setCustname(rs.getString(2));
                c1.setCity(rs.getString(3));
                c1.setPhone(rs.getString(4));
                c1.setPassword(rs.getString(5));
                customers.add(c1);
            }
        }
        catch(SQLException e){
            throw new Exception(e.getMessage());
        }
        return customers;
    }
    //	public boolean insertCustomer(Customer customer) throws Exception
    //	{
    //
    //		// SQL injection attacks - FYI
    //		String sql = "insert into customer values('"
    //				+ customer.getEmail()+ "','"
    //				+ customer.getCustname()+ "','"
    //				+ customer.getCity()+ "','"
    //				+ customer.getPhone()+ "','"
    //				+ customer.getPassword()+ "')";
    //		System.out.println(sql);
    //		Statement statement = conn.createStatement();
    //		try {
    //			statement.executeUpdate(sql);
    //		}
    //		catch(SQLException ex)
    //		{
    //			System.out.println("ERROR");
    //			throw new Exception(ex.getMessage());
    //		}
    //
    //
    //		return true;
    //  }
    public boolean insertCustomer(Customer customer) throws Exception
    {
        String sql = "insert into customer values(?,?,?,?,?)";
        System.out.println(sql);

        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, customer.getEmail());
            statement.setString(2,customer.getCustname());
            statement.setString(3,customer.getCity());
            statement.setString(4,customer.getPhone());
            statement.setString(5,customer.getPassword());

            statement.execute();
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR");
            throw new Exception(ex.getMessage());
        }
        return true;
    }

    public Customer getCustomerByEmail(String email) throws Exception
    {
        Customer customer = null;
        String sql = "select custname,city,phone from customer where email=?";
        PreparedStatement statement;

        try{
            statement = conn.prepareStatement(sql);
            statement.setString(1,email);
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                customer = new Customer();
                customer.setCustname(rs.getString(1));
                customer.setPhone(rs.getString(2));
                customer.setCity(rs.getString(3));
            }
            else{
                throw new Exception("No customer with "+email+" found");
            }
        }
        catch (SQLException e){
            throw new Exception(e.getMessage());
        }
        return customer;
    }
    public boolean updateCustomer(Customer customer) throws Exception
    {
        String sql = "update customer set city=?, phone=?, custname=? where email=?";
        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, customer.getEmail());
            statement.setString(2, customer.getPhone());
            statement.setString(3,customer.getCity());
            statement.setString(4,customer.getEmail());
            statement.execute();
        }
        catch (SQLException e){
            System.out.println("ERROR");
            throw new Exception(e.getMessage());
        }
        return true;
    }
    public boolean updatePassword(String newPassword, String email) throws Exception
    {
        String sql = "update customer set password=? where email=?";

        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,newPassword);
            statement.setString(2,email);

            statement.execute();
        }
        catch(SQLException e){
            System.out.println("ERROR");
            throw new Exception(e.getMessage());
        }
        return true;
    }
    public boolean deleteCustomer(String email) throws Exception
    {
        String sql = "delete from customer where email=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, email);
            statement.execute();
        }
        catch(SQLException ex)
        {
            System.out.println("ERROR");
            throw new Exception(ex.getMessage());
        }
        return true;
    }
    public boolean login(String password, String email) throws Exception
    {
        Customer customer = null;
        String sql = "select password from customer where email=?";

        try{
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,email);
            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                if(password.equals(rs.getString(1)))
                    return true;
            }
            throw new Exception("Invalid Credentials");
        }
        catch(SQLException e){
            System.out.println("ERROR");
            throw new Exception(e.getMessage());
        }
    }
}
