package com.food.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.food.demo.model.Order;

@Service
public class OrderService {

    List<Order> orderList =
            new ArrayList<>(Arrays.asList(
            		new Order(101,"Sathish","Pizza",2, 450.0),
            		new Order(102,"Sai","Burger",1, 200.0)
            ));

    public List<Order> getAllOrders() 
    {
        return orderList;
    }

    
    public Order getOrderById(int id) 
    {
        for (Order o : orderList) 
        {
            if (o.getOrderId() == id) 
            {
                return o;
            }
        }
        return null;
    }


    public Order addOrder(Order order) 
    {
        orderList.add(order);
        return order;
    }


    public String updateOrder(int id,Order order) 
    {
        for (Order o : orderList) 
        {
            if (o.getOrderId() == id) 
            {
                o.setCustomerName(order.getCustomerName());
                o.setFoodItem(order.getFoodItem());
                o.setQuantity(order.getQuantity());
                o.setPrice(order.getPrice());

                return "Order Updated Successfully";
            }
        }
        return "Order Not Found";
    }


    public String deleteOrder(int id) 
    {
        for (Order o : orderList) 
        {
            if (o.getOrderId() == id) 
            {
                orderList.remove(o);
                return "Order Deleted Successfully";
            }
        }
        return "Order Not Found";
    }
}
