package com.markcus.spring.helper;

import com.markcus.spring.modal.Favourite;
import com.markcus.spring.dto.FavouriteDto;
import com.markcus.spring.dto.ProductDto;
import com.markcus.spring.dto.UserDto;

public interface FavouriteMappingHelper {
	
	public static FavouriteDto map(final Favourite favourite) {
		return FavouriteDto.builder()
				.userId(favourite.getCustomerId())
				.productId(favourite.getItemId())
				.likeDate(favourite.getAddedTimestamp())
				.userDto(
						UserDto.builder()
							.userId(favourite.getCustomerId())
							.build())
				.productDto(
						ProductDto.builder()
						.productId(favourite.getItemId())
						.build())
				.build();
	}
	
	public static Favourite map(final FavouriteDto favouriteDto) {
		return Favourite.builder()
				.customerId(favouriteDto.getUserId())
				.itemId(favouriteDto.getProductId())
				.addedTimestamp(favouriteDto.getLikeDate())
				.build();
	}
	
	
	
}










