package com.movie.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @NotNull(message = "Ticket ID is required")
    private Integer ticketId;

    @NotBlank(message = "Movie name is required")
    private String movieName;

    @NotBlank(message ="Customer name cannot be empty")
    private String customerName;

    @NotBlank(message = "Seat number is required")
    private String seatNumber;

    @Positive(message ="Ticket price must be positive")
    private Double ticketPrice;


    private String bookingStatus;

    private Boolean premiumSeat;

    private String priceCategory;
}