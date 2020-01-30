package service;

public class ProductVO {
	int code;
	String name;
	int price;
	int coupon;
	double sale;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCoupon() {
		return coupon;
	}
	public void setCoupon(int coupon) {
		this.coupon = coupon;
	}
	public double getSale() {
		return sale;
	}
	public void setSale(double sale) {
		this.sale = sale;
	}
	@Override
	public String toString() {
		String result="상품코드:"+code+", 이름:"+name+", 가격:"+price+", 쿠폰:"+coupon+", 세일:"+sale;
		result+="\n지불가격"+(1-sale)*price;
		return result;
	}
	
}
