package com.neuedu.sell.repository;

import com.neuedu.sell.entity.OrderMaster;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    private static final String OPENID = "abc123";

    @Autowired
    private OrderMasterRepository repository;

    @Test
    public void saveTest(){
        OrderMaster orderMaster = repository.findOne("123456789");
        orderMaster.setBuyerAddress("伊拉克");
        orderMaster.setBuyerName("萨达姆");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setBuyerPhone("1");
        orderMaster.setOrderAmount(new BigDecimal(10.5));
        repository.save(orderMaster);
    }

    @Test
    public void findByBuyerOpenidTest(){
        Page<OrderMaster> page = repository.findByBuyerOpenid(OPENID,new PageRequest(0,2));
        for (OrderMaster orderMaster : page.getContent()) {
            System.out.println(orderMaster);
        }
    }

}