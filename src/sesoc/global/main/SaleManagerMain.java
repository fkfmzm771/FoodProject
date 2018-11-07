package sesoc.global.main;

import sesoc.global.manager.SaleManager;

public class SaleManagerMain {
	public static void main(String[] args) {
		SaleManager ss = new SaleManager();
		ss.getFile();
		ss.savaFile();
	}
}
