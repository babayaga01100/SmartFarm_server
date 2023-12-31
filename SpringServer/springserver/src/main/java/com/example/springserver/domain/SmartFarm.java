package com.example.springserver.domain;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "smart_farms")
@Entity
public class SmartFarm {

    public int getsf_id() {
        return sf_id;
    }

    public void setsf_id(int sf_id) {
        this.sf_id = sf_id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private int id;

    @Digits(integer = 3, fraction = 0)
    @JsonProperty("sf_id")
    @Column(nullable = true)
    private int sf_id;

    @JsonProperty("temp")
    @Column(precision = 3, scale = 1, nullable = true)
    private BigDecimal temp;

    @JsonProperty("hum")
    @Column(precision = 3, scale = 1, nullable = true)
    private BigDecimal hum;

    @JsonProperty("led_state")
    @Column(nullable = true)
    private short led_state;

    @JsonProperty("led_toggle")
    @Column(nullable = true)
    private short led_toggle;

    @JsonProperty("led_adj")
    @Column(scale = 0, nullable = true)
    // @Min(value = 1)
    // @Max(value = 5)
    private int led_adj;

    @JsonProperty("water_state")
    @Column(nullable = true)
    private short water_state;

    @JsonProperty("water_toggle")
    @Column(nullable = true)
    private short water_toggle;

    @JsonProperty("fan_state")
    @Column(nullable = true)
    private short fan_state;

    @JsonProperty("fan_toggle")
    @Column(nullable = true)
    private short fan_toggle;

}