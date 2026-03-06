package com.markcus.spring.helper;

import com.markcus.spring.modal.Address;
import com.markcus.spring.modal.User;
import com.markcus.spring.dto.AddressDto;
import com.markcus.spring.dto.UserDto;

public interface AddressMappingHelper {
	
	public static AddressDto map(final Address address) {
		return AddressDto.builder()
				.addressId(address.getAddressId())
				.fullAddress(address.getFullAddress())
				.postalCode(address.getPostalCode())
				.city(address.getCity())
				.userDto(
					UserDto.builder()
						.userId(address.getUser().getId())
						.firstName(address.getUser().getGivenName())
						.lastName(address.getUser().getFamilyName())
						.imageUrl(address.getUser().getProfilePictureUrl())
						.email(address.getUser().getEmail())
						.phone(address.getUser().getContactNumber())
						.build())
				.build();
	}
	
	public static Address map(final AddressDto addressDto) {
		return Address.builder()
				.addressId(addressDto.getAddressId())
				.fullAddress(addressDto.getFullAddress())
				.postalCode(addressDto.getPostalCode())
				.city(addressDto.getCity())
				.user(
					User.builder()
						.id(addressDto.getUserDto().getUserId())
						.givenName(addressDto.getUserDto().getFirstName())
						.familyName(addressDto.getUserDto().getLastName())
						.profilePictureUrl(addressDto.getUserDto().getImageUrl())
						.email(addressDto.getUserDto().getEmail())
						.contactNumber(addressDto.getUserDto().getPhone())
						.build())
				.build();
	}
	
	
	
}










