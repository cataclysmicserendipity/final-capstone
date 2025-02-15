package com.techelevator.dao;

import com.techelevator.model.Crust;
import com.techelevator.model.Pizza;
import com.techelevator.model.Size;
import com.techelevator.model.Topping;

public interface UserAccessDao {
    public void updateTopping(String name, Topping topping);

    public int addPizza(Pizza pizza);

    public void editPizza(int id, Pizza pizza);

    public void addPizzaOption(Topping topping);

    public void addCrust(Crust crust);

    public void addSize(Size size);
}
