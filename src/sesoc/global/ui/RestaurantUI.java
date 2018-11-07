package sesoc.global.ui;

import sesoc.global.manager.SaleManager;
import sesoc.global.vo.Food;
import sesoc.global.vo.Order;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RestaurantUI implements UI {
	private Scanner scanner;
	private List<Food> foodList;
	private SaleManager saleManager;

	public RestaurantUI() {
		saleManager = new SaleManager();
		saleManager.getFile();
	}

	//메뉴 주문 추가
	@Override
	public void insertOrder() {

	}

	//오더 삭제
	@Override
	public void deleteOrder() {

	}

	//메인메뉴
	@Override
	public void printMainMenu() {

	}

	//주문 메뉴
	@Override
	public void printOrderMenu() {

	}

	//주문 완료/생성
	@Override
	public Order makeOrder(String order) {
		return null;
	}

	//주문 가능한 메뉴 프린트
	@Override
	public void printFoodList(List<Food> food) {

	}

	@Override
	public int foodOrdered(Map<Food, Integer> foodMap) {
		return 0;
	}
}
