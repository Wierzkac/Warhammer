package com.warhammer.alfa.models.Character;

import jakarta.persistence.*;

import com.warhammer.alfa.enums.CharacteristicEnum;
import com.warhammer.alfa.enums.GenderEnum;
import com.warhammer.alfa.enums.RaceEnum;
import com.warhammer.alfa.models.Career.Career;
import com.warhammer.alfa.models.Skill.Skill;
import com.warhammer.alfa.models.Talent.Talent;
import com.warhammer.alfa.models.User.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name = "characters")
@Data
@NoArgsConstructor
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "race")
    private RaceEnum race;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_career_id")
    private Career currentCareer;

    @ElementCollection
    @CollectionTable(name = "character_characteristics", 
        joinColumns = @JoinColumn(name = "character_id"))
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "characteristic")
    @Column(name = "value")
    private Map<CharacteristicEnum, Integer> characteristics = new HashMap<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "character_talents",
        joinColumns = @JoinColumn(name = "character_id"),
        inverseJoinColumns = @JoinColumn(name = "talent_id")
    )
    private Set<Talent> talents = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "character_skills",
        joinColumns = @JoinColumn(name = "character_id"),
        inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private Set<Skill> skills = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "experience_points_free")
    private int experencePointsFree;

    @Column(name = "experience_points_total")
    private int experencePointsTotal;
}
