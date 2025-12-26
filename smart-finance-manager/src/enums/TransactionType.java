package enums;

enum TransactionType{

    EXPENSE("EXPENSE"),
    INCOME("INCOME");

    private final String label;
    TransactionType(String label){
        this.label = label;
    }

    String getLabel(){
        return this.label;
    }
}