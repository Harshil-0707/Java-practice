package enums;

public enum TransactionType{

    EXPENSE(1),
    INCOME(2);

    private final int id;
    TransactionType(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }
}