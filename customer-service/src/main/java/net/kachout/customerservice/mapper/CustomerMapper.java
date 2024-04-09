package net.kachout.customerservice.mapper;

import net.kachout.customerservice.dtos.CustomerDto;
import net.kachout.customerservice.dtos.CustomersDto;
import net.kachout.customerservice.entity.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerMapper {
    public   ModelMapper modelMapper=new ModelMapper();
    public CustomerDto customerToCustomerDto(Customer c)
    {
        return modelMapper.map(c, CustomerDto.class);
    }
    public Customer customerDtoToCustomer(CustomerDto customerDto)
    {
        return modelMapper.map(customerDto, Customer.class);
    }
    CustomersDto listCustomerToListCustomers(List<Customer> customers){
        return modelMapper.map(customers,CustomersDto.class);
    }
   /* List<Customer> customers listCustomersDtoToListCustomers(CustomersDto customersDto)
    {
        return modelMapper.map(customersDto, List<?extends Customer>);
    }*/


}
