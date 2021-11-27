package s.s.dtos;

public class OrderDto {
   int count;
   int total;
   String orderItems;
   int userId;

   public OrderDto() {
   }

   public OrderDto(int count, int total, String orderItems, int userId) {
      this.count = count;
      this.total = total;
      this.orderItems = orderItems;
      this.userId = userId;
   }

   public int getCount() {
      return this.count;
   }

   public void setCount(int count) {
      this.count = count;
   }

   public int getTotal() {
      return this.total;
   }

   public void setTotal(int total) {
      this.total = total;
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
