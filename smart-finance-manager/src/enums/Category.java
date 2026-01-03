package enums;

import java.util.HashMap;
import java.util.Map;

public enum Category{

    FOOD(1),
    TRANSPORT(2),
    RENT(3),
    UTILITIES(4),
    ENTERTAINMENT(5);

    private final int id;
    private static final Map<Integer,Category> BY_ID = new HashMap<>();

    static {
        for(Category c : Category.values()){
            BY_ID.put(c.id,c);
        }
    }

    Category(int id){
        this.id = id;
    }

    public static Category fromId(int id){
        Category result = BY_ID.get(id);
        if(result == null){
            throw new IllegalArgumentException("Unkown id: " + id);
        }
        return result;
    }

    public int getId(){
        return this.id;
    }

}