package sesoc.global.manager;

import sesoc.global.vo.Food;
import sesoc.global.vo.Order;

import java.util.List;

public interface Manager {
	public void getFile();

	public List<Food> getFoods();

	public Order findOrder(int findData);

	public Order deleteOrder(int delData);

	public void showAll();

	public boolean insertOrder(Order inOrderData);

	public void savaFile();

	public int[] calcSalesTotal();

}
