package com.gongdel.doc.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@Access(AccessType.FIELD)
@ToString(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String phoneNumber;

    private User(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    @Builder
    public static User createUser(String name, String email, String phoneNumber) {
        return new User(name, email, phoneNumber);
    }
}