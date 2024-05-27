package io.namoosori.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "customer_tb")
@NoArgsConstructor
@ToString
@Getter @Setter
@TableGenerator(
        name="id_generator",
        table="customer_id",
        pkColumnName = "id_name",
        pkColumnValue = "customer_id",
        initialValue = 0,
        allocationSize = 1
)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
    private Long id;

    private String name;
    private long registrationDate;

    public Customer(Long id, String name) {
        this.id = id;
        this.name = name;
        this.registrationDate = System.currentTimeMillis();
    }

    public static Customer sample() {
        return new Customer(1L, "kim");
    }
}
