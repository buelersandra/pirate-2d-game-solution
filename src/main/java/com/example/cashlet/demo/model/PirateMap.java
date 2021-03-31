package com.example.cashlet.demo.model;

import java.util.Optional;

public class PirateMap{
    private String type;
    private Optional<Object> amount;

    PirateMap(String type, Optional<Object> amount){
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getAmount() {
        return amount.isPresent() ? amount.get() : null;
    }

    public void setAmount(Optional<Object> amount) {
        this.amount = amount;
    }

  

    
}

