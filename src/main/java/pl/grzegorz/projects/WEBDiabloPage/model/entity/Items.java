package pl.grzegorz.projects.WEBDiabloPage.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "items")
public class Items implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String runes;
    private String images;
    private String itemCode;
    @JsonIgnore
    public Items(String runes, String images) {
        this.runes = runes;
        this.images = images;
    }
}
