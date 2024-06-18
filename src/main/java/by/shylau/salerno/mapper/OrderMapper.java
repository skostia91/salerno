package by.shylau.salerno.mapper;

import by.shylau.salerno.dto.request.OrderRequest;
import by.shylau.salerno.dto.responce.OrderResponse;
import by.shylau.salerno.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface OrderMapper {

    Order createOrder(OrderRequest orderRequest);

    OrderResponse toResponse(Order order);

    List<OrderResponse> toResponseList(List<Order> userList);
}
