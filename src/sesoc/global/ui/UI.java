package sesoc.global.ui;

import sesoc.global.vo.Food;
import sesoc.global.vo.Order;

import java.util.List;
import java.util.Map;

public interface UI {
	public void insertOrder();

	public void deleteOrder();

	public void printMainMenu();

	public void printOrderMenu();

	public Order makeOrder(String order);

	public void printFoodList(List<Food> food);

	public int foodOrdered(Map<Food, Integer> foodMap);
}
