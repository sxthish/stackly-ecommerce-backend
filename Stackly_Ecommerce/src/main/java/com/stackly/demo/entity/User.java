package com.stackly.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="users")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

	private String userName;

	@Column(unique = true)
    private String email;

	private Long userPass;

	private Long phoneNumber;

	private LocalDateTime createAt;

	private LocalDateTime updateAt;


	@OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL
) 
    private List<Address> addresses =new ArrayList<>();

	
	@ManyToMany(
        cascade = CascadeType.ALL
)
    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name="user_id"),
        inverseJoinColumns = @JoinColumn(name="role_id")
)
    private List<Role> roles =new ArrayList<>();


	@OneToMany(
        mappedBy = "user",
        cascade = CascadeType.ALL
)
    private List<Review> reviews =new ArrayList<>();



}
