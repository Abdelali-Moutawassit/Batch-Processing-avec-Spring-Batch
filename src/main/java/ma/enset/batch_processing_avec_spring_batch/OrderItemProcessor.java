package ma.enset.batch_processing_avec_spring_batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class OrderItemProcessor implements ItemProcessor<Order, Order> {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderItemProcessor.class);

    @Override
    public Order process(Order order) throws Exception {
        double discountedAmount = order.amount() * 0.9; // Apply 10% discount
        Order transformedOrder = new Order(order.orderId(), order.customerName(), discountedAmount);
        LOGGER.info("order ID " + order.orderId() + " with amount " +order.amount()+" discount amount " +discountedAmount+" "+transformedOrder);
        return transformedOrder;
    }
}
