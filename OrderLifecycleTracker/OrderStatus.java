public enum OrderStatus{
    
    PLACED("PLACED"){
        @Override
        public boolean canTransitionTo(OrderStatus next){
            return next == PAID || next == CANCELLED;
        }
    },
    PAID("PAID"){
        @Override
        public boolean canTransitionTo(OrderStatus next){
            return next == PACKED || next == CANCELLED;
        }
    },
    PACKED("PACKED"){
        @Override
        public boolean canTransitionTo(OrderStatus next){
            return next == SHIPPED;
        }

    },
    SHIPPED("SHIPPED"){
        @Override
        public boolean canTransitionTo(OrderStatus next){
            return next == DELIVERED;
        }
    }, 
    DELIVERED("DELIVERED"){
        @Override
        public boolean canTransitionTo(OrderStatus next){
            return false;
        }
    }, 
    CANCELLED("CANCELLED"){
        @Override
        public boolean canTransitionTo(OrderStatus next){
            return false;
        }
    }

    private final String label;

    OrderStatus(String label){
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }

    public boolean canTransitionTo(OrderStatus next){
        return false;
    }

    @Override
    public String toString(){
        return label;
    }


}