package com.redstarinfo.sale.service.Impl;

import com.redstarinfo.sale.dataobject.OrderDetail;
import com.redstarinfo.sale.dataobject.ProductInfo;
import com.redstarinfo.sale.dto.OrderDTO;
import com.redstarinfo.sale.enums.ResultEnum;
import com.redstarinfo.sale.exception.SellException;
import com.redstarinfo.sale.repository.OrderDetailRepository;
import com.redstarinfo.sale.service.OrderService;
import com.redstarinfo.sale.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);

        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            orderAmount = orderDetail.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            //orderDetail.setDetailId();
            //orderDetail.setOrderId();
            orderDetailRepository.save(orderDetail);
        }
        return null;
    }

    @Override
    public OrderDTO findONe(String orderId) {


        return null;
    }

    @Override
    public List<OrderDTO> findList(String buyerOpenid, Pageable pageable) {


        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {


        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {


        return null;
    }

    @Override
    public OrderDTO pay(OrderDTO orderDTO) {


        return null;
    }
}
