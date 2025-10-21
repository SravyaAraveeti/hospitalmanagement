package com.hospitalmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "hospitals")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hospital_name", nullable = false)
    @NotBlank(message = "Hospital name is required")
    @Pattern(regexp = "^[A-Za-z ]+$", message = "Hospital name must contain only letters and spaces")
    private String hospitalName;

    @Column(length = 500)
    private String address;

    @Column(name = "contact_number", length = 50)
    @NotBlank(message = "Contact number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Contact number must be exactly 10 digits")
    private String contactNumber;

    @Column(length = 150)
    @Email(message = "Invalid email format")
    private String email;

    private String website;
    private String hospitalType;
    private String registrationNumber;

    @Min(value = 1800, message = "Year must be >= 1800")
    @Max(value = 2100, message = "Year cannot be beyond 2100")
    private Integer yearEstablished;

    @PositiveOrZero(message = "Outpatient fee cannot be negative")
    private Double outpatientFee;

    @PositiveOrZero(message = "Bed availability cannot be negative")
    private Integer bedAvailability;

    private String bedCategory;
    private Boolean emergencyServices = false;

    @Column(columnDefinition = "TEXT")
    private String departments;

    private Boolean ambulanceAvailability = false;
    private Boolean pharmacyOnsite = false;

    @Column(columnDefinition = "TEXT")
    private String diagnosticServices;

    private String timings;
    private Boolean twentyfourAvailability = false;
    private String languagesSpoken;

    // ✅ NEW FIELDS FOR LOGIN
    @Column(unique = true, nullable = false, length = 50)
    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @Pattern(regexp = "^[A-Za-z0-9._-]+$", message = "Username can contain letters, numbers, dot, underscore and dash only")
    private String username;

    @Column(nullable = false)
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }

    // ------------------- Getters and Setters -------------------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getHospitalName() { return hospitalName; }
    public void setHospitalName(String hospitalName) { this.hospitalName = hospitalName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    public String getHospitalType() { return hospitalType; }
    public void setHospitalType(String hospitalType) { this.hospitalType = hospitalType; }

    public String getRegistrationNumber() { return registrationNumber; }
    public void setRegistrationNumber(String registrationNumber) { this.registrationNumber = registrationNumber; }

    public Integer getYearEstablished() { return yearEstablished; }
    public void setYearEstablished(Integer yearEstablished) { this.yearEstablished = yearEstablished; }

    public Double getOutpatientFee() { return outpatientFee; }
    public void setOutpatientFee(Double outpatientFee) { this.outpatientFee = outpatientFee; }

    public Integer getBedAvailability() { return bedAvailability; }
    public void setBedAvailability(Integer bedAvailability) { this.bedAvailability = bedAvailability; }

    public String getBedCategory() { return bedCategory; }
    public void setBedCategory(String bedCategory) { this.bedCategory = bedCategory; }

    public Boolean getEmergencyServices() { return emergencyServices; }
    public void setEmergencyServices(Boolean emergencyServices) { this.emergencyServices = emergencyServices; }

    public String getDepartments() { return departments; }
    public void setDepartments(String departments) { this.departments = departments; }

    public Boolean getAmbulanceAvailability() { return ambulanceAvailability; }
    public void setAmbulanceAvailability(Boolean ambulanceAvailability) { this.ambulanceAvailability = ambulanceAvailability; }

    public Boolean getPharmacyOnsite() { return pharmacyOnsite; }
    public void setPharmacyOnsite(Boolean pharmacyOnsite) { this.pharmacyOnsite = pharmacyOnsite; }

    public String getDiagnosticServices() { return diagnosticServices; }
    public void setDiagnosticServices(String diagnosticServices) { this.diagnosticServices = diagnosticServices; }

    public String getTimings() { return timings; }
    public void setTimings(String timings) { this.timings = timings; }

    public Boolean getTwentyfourAvailability() { return twentyfourAvailability; }
    public void setTwentyfourAvailability(Boolean twentyfourAvailability) { this.twentyfourAvailability = twentyfourAvailability; }

    public String getLanguagesSpoken() { return languagesSpoken; }
    public void setLanguagesSpoken(String languagesSpoken) { this.languagesSpoken = languagesSpoken; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
