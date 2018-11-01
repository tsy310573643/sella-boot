package com.neuedu.sell.service.impl;

import com.neuedu.sell.dto.OrderDTO;
import com.neuedu.sell.entity.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void createTest(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("张三");
        orderDTO.setBuyerPhone("133333333");
        orderDTO.setBuyerAddress("西七道");
        orderDTO.setBuyerOpenid("abc123");
        List<OrderDetail> list = new ArrayList<>();
        list.add(new OrderDetail("123456",10));
        list.add(new OrderDetail("1234567",2));
        orderDTO.setOrderDetailList(list);
        orderService.create(orderDTO);
    }

}