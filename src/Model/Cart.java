package Model;

import java.util.HashMap;
import java.util.Map;

public class Cart{
	private HashMap<String, Items> CartItems;
	public Cart() {
		CartItems= new HashMap<>();
	}
	public Cart(HashMap<String, Items> cartItems) {
	this.CartItems = cartItems;
	
}
	public HashMap<String, Items> getCartItems() {
		return CartItems;
	}
	public void setCartItems(HashMap<String, Items> cartItems) {
		CartItems = cartItems;
	}
	
	//Thêm sản phẩm vào giỏ hàng
	public void plusToCart(String key, Items item)
	{
		boolean check= CartItems.containsKey(key);
		if(check) {
			int SoLuongCu=item.getSoLuong();
			item.setSoLuong(SoLuongCu+1);
			CartItems.put(key, item);
		}
		else
		{
			CartItems.put(key, item);
		}
	}
	//Trá»« sá»‘ lÆ°á»£ng sáº£n pháº©m
	public void subToCart(String key,Items item)
	{
		boolean check=CartItems.containsKey(key);
		if(check) {
			int SoLuongCu=item.getSoLuong();
			if(SoLuongCu<=1) {
				CartItems.remove(key);
			}
			else {
				item.setSoLuong(SoLuongCu-1);
				CartItems.put(key, item);
			}
		}
	}
	//XÃ³a sáº£n pháº©m khá»�i giá»� hÃ ng
	public void removeToCart(String key)
	{
		boolean check=CartItems.containsKey(key);
		if(check)
		{
			CartItems.remove(key);
		}
	}
	//Ä�áº¿m tá»•ng sá»‘ lÆ°á»£ng máº·t hÃ ng
	public int countItem()
	{
		return CartItems.size();
	}
	//Tá»•ng tiá»�n
	public long sumTotalCart() {
		long Tong=0;
		for(Map.Entry<String, Items>list: CartItems.entrySet()) {
			Tong+=list.getValue().getSanpham().getGia()*list.getValue().getSoLuong();
		}
		return Tong;
		}
	
	
}

