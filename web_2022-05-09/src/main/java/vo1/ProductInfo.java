package vo1;

import java.io.File;
import java.time.LocalDateTime;

public class ProductInfo {
	private int idx;
	private String name;
	private String category;
	private int stock;
	private int price;
	private String img;
	private LocalDateTime insertDate;
	private String list;
	
	public ProductInfo() {
		
	}
	
	public ProductInfo(int idx,String name, String category, int stock, int price, String img) {
		this(idx, name, category, stock, price, img, null);
	}
	
	public ProductInfo(String name, String category, int stock, int price, String img, LocalDateTime insertDate) {
		this(0, name, category, stock, price, img, insertDate);
	}
	
	public ProductInfo(int idx, String name, String category, int stock, int price, String img, LocalDateTime insertDate) {
		this.idx = idx;
		this.name = name;
		this.category = category;
		this.stock = stock;
		this.price = price;
		this.img = img;
		this.insertDate = insertDate;
	}
	
	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public LocalDateTime getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(LocalDateTime insertDate) {
		this.insertDate = insertDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
