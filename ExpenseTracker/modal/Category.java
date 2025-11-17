package modal;

public enum Category{
    FOOD("Food"),
    TRAVEL("Travel"),
    SHOPPING("Shopping"),
    BILLS("Bills"),
    OTHERS("Others");

    private String label;

    Category(String label) {
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }

}