package mybatis.bakery;

public class BakeryVO {
	int bakeryid;
	String bakeryname;
	int price;
	int balance;
	String bakeryimage;
	
	public BakeryVO() {} //기본생성자
	
	public BakeryVO(String bakeryname, int price, int balance, String bakeryimage) {
		super();
		this.bakeryname = bakeryname;
		this.price = price;
		this.balance = balance;
		this.bakeryimage = bakeryimage;
	}
	public int getBakeryid() {
		return bakeryid;
	}
	public void setBakeryid(int bakeryid) {
		this.bakeryid = bakeryid;
	}
	public String getBakeryname() {
		return bakeryname;
	}
	public void setBakeryname(String bakeryname) {
		this.bakeryname = bakeryname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getBakeryimage() {
		return bakeryimage;
	}
	public void setBakeryimage(String bakeryimage) {
		this.bakeryimage = bakeryimage;
	}
	
}
