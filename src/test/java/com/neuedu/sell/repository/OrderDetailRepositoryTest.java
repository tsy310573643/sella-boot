package com.neuedu.sell.repository;

import com.neuedu.sell.entity.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("4567890");
        orderDetail.setOrderId("123456789");
        orderDetail.setProductIcon("aaa");
        orderDetail.setProductId("123456");
        orderDetail.setProductName("皮皮虾");
        orderDetail.setProductPrice(new BigDecimal(35));
        orderDetail.setProductQuantity(5);
        repository.save(orderDetail);
    }

    @Test
    public void findByOrderIdTest(){
        for (OrderDetail orderDetail : repository.findByOrderId("123456789")) {
            System.out.println(orderDetail);
        }
    }

}