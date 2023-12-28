package com.project.cleansnowtown.domain.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.cleansnowtown.domain.BaseEntity;
import com.project.cleansnowtown.domain.Search;
import com.project.cleansnowtown.domain.order.Order;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Payment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    @Embedded
    private Search search;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;

    @JsonIgnore
    @OneToOne(mappedBy = "payment", fetch = LAZY)
    private Order order;

    @Builder
    private Payment(Search search, PaymentStatus paymentStatus, Order order){
        this.search = search;
        this.paymentStatus = paymentStatus;
        this.order = order;
    }
}
