package com.hai.idao;

import java.util.List;

import com.hai.model.Wishlist;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IWishlistDAO {
	
	public boolean createWishlist(Wishlist wishlist);
	public Wishlist readWishlist(int wishlistID);
	public boolean updateWishlist(Wishlist wishlist);
	public boolean deleteWishlist(int wishlistID);
	public List<Wishlist> readAllWishlists();
	public List<Wishlist> readWishlistByProperty(String name, Object value);
	
}
