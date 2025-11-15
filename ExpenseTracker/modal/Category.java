package modal;

public enum Category{
    FOOD("Food & Dining"),
    TRAVEL("Travel & Commute"),
    SHOPPING("Shopping"),
    BILLS("Utility Bills"),
    OTHERS("Miscellaneous");

    private String label;

    Category(String label) {
        this.label = label;
    }

    public String getLabel(){
        return this.label;
    }

}