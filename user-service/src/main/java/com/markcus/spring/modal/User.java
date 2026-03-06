package com.markcus.spring.modal;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "platform_users")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true, exclude = {"addresses", "credential"})
@Data
@Builder
public final class User extends AbstractMappedEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, updatable = false)
	private Integer id;
	
	@Column(name = "given_name")
	private String givenName;
	
	@Column(name = "family_name")
	private String familyName;
	
	@Column(name = "profile_picture_url")
	private String profilePictureUrl;
	
	@Email(message = "*Input must be in Email format!**")
	private String email;
	
	@Column(name = "contact_number")
	private String contactNumber;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "platformUser", fetch = FetchType.LAZY)
	private Set<Address> userAddresses;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "platformUser")
	private Credential userCredential;
	
}










