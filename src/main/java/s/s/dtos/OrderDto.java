package s.s.dtos;

public class OrderDto {
   String orderItems;
   int userId;

   public OrderDto(String orderItems) {
      this.orderItems = orderItems;
   }

   public String getOrderItems() {
      return this.orderItems;
   }

   public void setOrderItems(String orderItems) {
      this.orderItems = orderItems;
   }

   public int getUserId() {
      return this.userId;
   }

   public void setUserId(int userId) {
      this.userId = userId;
   }
}
