package io.lcalmsky.app.modules.account.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccount is a Querydsl query type for Account
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccount extends EntityPathBase<Account> {

    private static final long serialVersionUID = 1318177927L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccount account = new QAccount("account");

    public final QAuditingEntity _super = new QAuditingEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdDate = _super.createdDate;

    public final StringPath email = createString("email");

    public final StringPath emailToken = createString("emailToken");

    public final DateTimePath<java.time.LocalDateTime> emailTokenGeneratedAt = createDateTime("emailTokenGeneratedAt", java.time.LocalDateTime.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isValid = createBoolean("isValid");

    public final DateTimePath<java.time.LocalDateTime> joinedAt = createDateTime("joinedAt", java.time.LocalDateTime.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> lastModifiedDate = _super.lastModifiedDate;

    public final StringPath nickname = createString("nickname");

    public final QAccount_NotificationSetting notificationSetting;

    public final StringPath password = createString("password");

    public final QAccount_Profile profile;

    public final SetPath<io.lcalmsky.app.modules.tag.domain.entity.Tag, io.lcalmsky.app.modules.tag.domain.entity.QTag> tags = this.<io.lcalmsky.app.modules.tag.domain.entity.Tag, io.lcalmsky.app.modules.tag.domain.entity.QTag>createSet("tags", io.lcalmsky.app.modules.tag.domain.entity.Tag.class, io.lcalmsky.app.modules.tag.domain.entity.QTag.class, PathInits.DIRECT2);

    public final SetPath<Zone, QZone> zones = this.<Zone, QZone>createSet("zones", Zone.class, QZone.class, PathInits.DIRECT2);

    public QAccount(String variable) {
        this(Account.class, forVariable(variable), INITS);
    }

    public QAccount(Path<? extends Account> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccount(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccount(PathMetadata metadata, PathInits inits) {
        this(Account.class, metadata, inits);
    }

    public QAccount(Class<? extends Account> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.notificationSetting = inits.isInitialized("notificationSetting") ? new QAccount_NotificationSetting(forProperty("notificationSetting")) : null;
        this.profile = inits.isInitialized("profile") ? new QAccount_Profile(forProperty("profile")) : null;
    }

}

