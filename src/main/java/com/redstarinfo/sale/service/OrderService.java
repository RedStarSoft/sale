package com.redstarinfo.sale.service;

import com.redstarinfo.sale.dataobject.OrderDetail;
import com.redstarinfo.sale.dto.OrderDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderService {
    //Create
    OrderDTO create(OrderDTO orderDTO);

    //query one
    OrderDTO findONe(String orderId);

    //query list
    List<OrderDTO> findList(String buyerOpenid, Pageable pageable);

    //cancel
    OrderDTO cancel(OrderDTO orderDTO);

    //finish
    OrderDTO finish(OrderDTO orderDTO);

    //pay
    OrderDTO pay(OrderDTO orderDTO);
}
