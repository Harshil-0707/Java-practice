public enum OrderStatus{
    
    PLACED("PLACED"){
        @Override
        public boolean canTransitionTo(){
            return false;
        }
    },
    PAID("PAID"){
        @Override
        public boolean canTransitionTo(){
            return false;
        }
    },
    PACKED("PACKED"){
        @Override
        public boolean canTransitionTo(){
            return false;
        }

    },
    SHIPPED("SHIPPED"){
        @Override
        public boolean canTransitionTo(){
            return false;
        }
    }, 
    DELIVERED("DELIVERED"){
        @Override
        public boolean canTransitionTo(){
            return false;
        }
    }, 
    CANCELLED("CANCELLED"){
        @Override
        public boolean canTransitionTo(){
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

    public boolean canTransitionTo(){
        return false;
    }

    @Override
    public String toString(){
        return label;
    }


}