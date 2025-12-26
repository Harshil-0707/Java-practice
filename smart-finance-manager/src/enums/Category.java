package enums;

enum Category{
    FOOD("FOOD"),
    TRANSPORT("TRANSPORT"),
    RENT("RENT"),
    UTILITIES("UTILITIES"),
    ENTERTAINMENT("ENTERTAINMENT");

    private final String label;

    Category(String label){
        this.label = label;
    }

    String getLabel(){
        return this.label;
    }

}