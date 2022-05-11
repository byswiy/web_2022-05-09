package util1;

import java.util.ArrayList;
import java.util.List;

public class ProdValidator1 {
	public boolean nameValidator(String name) {
		boolean correctName = false;
		correctName = name.length() >= 1 && name.length() <= 30;
		if(!correctName) {
			return false;
		}
		return correctName;
	}
	
	public boolean categoryValidator(String category) {
		boolean correctCategory = false;
		
		List<String> categoryList = new ArrayList<>();
		categoryList.add("스마트폰");
		categoryList.add("태블릿");
		categoryList.add("노트북");

		for(String list : categoryList) {
			if(list.equals(category)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean stockValidator(int stock) {
		boolean correctStock = false;
		
		correctStock = stock >= 0;
		return correctStock;
	}
	
	public boolean priceValidator(int price) {
		boolean correctPrice = false;
		
		correctPrice = price >= 0;
		return correctPrice;
	}
}
