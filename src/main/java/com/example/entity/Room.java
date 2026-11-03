package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "room_number", nullable = false, unique = true)
    private String roomNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private RoomType roomType;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "price_per_night", nullable = false, precision = 10, scale = 2)
    private BigDecimal pricePerNight;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "available", nullable = false)
    private boolean available;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY)
    private List<Booking> bookingList;

}
