package pl.grzegorz.projects.WEBDiabloPage.model.entity;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@Table(name = "statistics")
public class Statistics implements Serializable {

    @Column(name = "statistics_Id",unique=true, nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "life")
    private int life;
    @Column(name = "mana")
    private int mana;

    @Column(name = "toSorceressSkillLevel")
    private int toSorceressSkillLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn( name = "item_id", insertable = false, updatable = false)
    private Items item;

    public Statistics(int life,
                      int mana,
                      int toSorceressSkillLevel

                      ) {

        this.life = life;
        this.mana = mana;
        this.toSorceressSkillLevel = toSorceressSkillLevel;

    }

}
