public enum OrderStatus{
    
    PLACED("Placed"){
        @Override
        public boolean canTransitionTo(OrderStatus next){
            return next == PAID || next == CANCELLED;
        }
    },
    PAID("Paid"){
        @Override
        public boolean canTransitionTo(OrderStatus next){
            return next == PACKED || next == CANCELLED;
        }
    },
    PACKED("Packed"){
        @Override
        public boolean canTransitionTo(OrderStatus next){
            return next == SHIPPED;
        }

    },
    SHIPPED("Shipped"){
        @Override
        public boolean canTransitionTo(OrderStatus next){
            return next == DELIVERED;
        }
    }, 
    DELIVERED("Delivered"){
        @Override
        public boolean canTransitionTo(OrderStatus next){
            return false;
        }
    }, 
    CANCELLED("Cancelled"){
        @Override
        public boolean canTransitionTo(OrderStatus next){
            return false;
        }
    };

    private final String label;

    OrderStatus(String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

    public boolean canTransitionTo(OrderStatus next){
        return false;
    }

    @Override
    public String toString(){
        return label;
    }


}