package domain;

import enums.*;
import java.util.UUID;
import java.time.LocalDate;

public class Transaction{
    private final String id;
    private final String notes;
    private final double amount;
    private final Status status;
    private final LocalDate date;
    private final Category category;
    private final TransactionType type;

    private Transaction(Builder builder){
        this.id = UUID.randomUUID().toString().substring(0,6);
        this.date = builder.date;
        this.type = builder.type;
        this.notes = builder.notes;
        this.amount = builder.amount;
        this.status = builder.status;
        this.category = builder.category;
    }

    // ? Builder class for Setter

    public static class Builder{

        private final String notes;
        private final double amount;
        private final Status status;
        private final LocalDate date;
        private final Category category;
        private final TransactionType type;

        public Builder notes(String notes){
            this.notes = notes;
            return this;
        }

        public Builder amount(double amount){
            this.amount = amount;
            return this;
        }

        public Builder date(LocalDate date){
            this.date = date;
            return this;
        }

        public Builder category(Category category){
            this.category = category;
            return this;
        }

        public Builder type(TransactionType type){
            this.type = type;
            return this;
        }

        public Builder status(Status status){
            this.status = status;
            return this;
        }

        public Transaction build(){
            return new Transaction(this);
        }
    }

    // ? Getters

    public String getId(){
        return this.id;
    }

    public String getNotes(){
        return this.notes;
    }

    public LocalDate getDate(){
        return this.date;
    }
    
    public double getAmount(){
        return this.amount;
    }

    public Status getStatus(){
        return this.status;
    }

    public Category getCategory(){
        return this.category;
    }

    public TransactionType getType(){
        return this.type;
    }

}