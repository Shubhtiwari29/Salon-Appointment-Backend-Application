package com.user.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;

    @NotBlank(message = "UserName Is Required")
    private String userName;

    @NotBlank(message = "email Is Required")
    @Email(message = "Should Be Valid Email")
    private String email;

    private String phone;

    @NotBlank(message = "Role Is Required")
    private String role;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @NotBlank(message = "Password Is Required")
    private String password;

    public User() {

    }

    public User(Long id, String fullName, String userName, String email, String phone, String role, LocalDateTime createdAt, LocalDateTime updatedAt, String password) {
        this.id = id;
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.phone = phone;
        this.role = role;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public @NotBlank(message = "UserName Is Required") String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank(message = "UserName Is Required") String userName) {
        this.userName = userName;
    }

    public @NotBlank(message = "email Is Required") @Email(message = "Should Be Valid Email") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "email Is Required") @Email(message = "Should Be Valid Email") String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public @NotBlank(message = "Role Is Required") String getRole() {
        return role;
    }

    public void setRole(@NotBlank(message = "Role Is Required") String role) {
        this.role = role;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public @NotBlank(message = "Password Is Required") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "Password Is Required") String password) {
        this.password = password;
    }
}
