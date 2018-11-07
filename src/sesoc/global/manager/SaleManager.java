package sesoc.global.manager;

import sesoc.global.vo.Food;
import sesoc.global.vo.Order;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SaleManager implements Manager {
	private final static String FILE_NAME = "src/menu.txt";
	private FileReader fr;
	private BufferedReader br;
	private FileWriter fw;
	private BufferedWriter bw;

	private List<Food> foodlist;
	private List<Order> orderList;


	//기본 생성자
	public SaleManager() {
		foodlist = new ArrayList<>();
		orderList = new ArrayList<>();
	}

	//메뉴 파일 불러오기
	@Override
	public void getFile() {
		try {
			fr = new FileReader(FILE_NAME);
			br = new BufferedReader(fr);

			String menuData = "";
			while ((menuData = br.readLine()) != null) {
				String[] menuSet = menuData.trim().split(",");
				Food food = new Food();
				food.setFoodNo(Integer.parseInt(menuSet[0]));
				food.setFoodName(menuSet[1]);
				food.setPrice(Integer.parseInt(menuSet[2]));
				foodlist.add(food);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) br.close();
				if (fr != null) fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//푸드 리스트 반환
	@Override
	public List<Food> getFoods() {
		return foodlist;
	}

	//삭제를 위한 오더 검색(값이 없는 경우 null반환)
	@Override
	public Order findOrder(int findData) {
		return null;
	}

	//오더 삭제
	@Override
	public Order deleteOrder(int delData) {
		return null;
	}

	//당일 정산 매출 출력
	@Override
	public void showAll() {

	}

	//매장주문_배달주문 추가 메뉴
	@Override
	public boolean insertOrder(Order inOrderData) {
		return false;
	}

	//매출 현황 저장(Report_x월x일.dat)형식/종료
	@Override
	public void savaFile() {
		SimpleDateFormat sf1 = new SimpleDateFormat("MM월dd일");
		SimpleDateFormat sf2 = new SimpleDateFormat("yyyy년 MM월 dd일");
		long timeMillis = System.currentTimeMillis();
		StringBuffer file_name = new StringBuffer();
		//CalcSalesTotalFile 임의로 만든 폴더
		file_name.append("src\\CalcSalesTotalFile\\");
		file_name.append("Report_");
		file_name.append(sf1.format(timeMillis));
		file_name.append(".dat");

		try {
			fw = new FileWriter(file_name.toString());
			bw = new BufferedWriter(fw);

			bw.write("[ SCIT Restaurant 매출 보고서 ]\n");
			bw.write(sf2.format(timeMillis) + "\n");

			for (Order order : orderList) {
				bw.write(order.showOrderSituation());
			}


		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) bw.close();
				if (fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	//매장/배달 판매 금액 계산
	@Override
	public int[] calcSalesTotal() {
		return new int[0];
	}
}
