package com.gongdel.doc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@ToString
@MappedSuperclass
@Access(AccessType.FIELD)
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class BaseEntity implements Serializable {

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createAt;

    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime updateAt;
}