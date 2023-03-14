package io.lcalmsky.app.modules.study.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStudy is a Querydsl query type for Study
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStudy extends EntityPathBase<Study> {

    private static final long serialVersionUID = 1723061055L;

    public static final QStudy study = new QStudy("study");

    public final BooleanPath closed = createBoolean("closed");

    public final DateTimePath<java.time.LocalDateTime> closedDateTime = createDateTime("closedDateTime", java.time.LocalDateTime.class);

    public final StringPath fullDescription = createString("fullDescription");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final SetPath<io.lcalmsky.app.modules.account.domain.entity.Account, io.lcalmsky.app.modules.account.domain.entity.QAccount> managers = this.<io.lcalmsky.app.modules.account.domain.entity.Account, io.lcalmsky.app.modules.account.domain.entity.QAccount>createSet("managers", io.lcalmsky.app.modules.account.domain.entity.Account.class, io.lcalmsky.app.modules.account.domain.entity.QAccount.class, PathInits.DIRECT2);

    public final NumberPath<Integer> memberCount = createNumber("memberCount", Integer.class);

    public final SetPath<io.lcalmsky.app.modules.account.domain.entity.Account, io.lcalmsky.app.modules.account.domain.entity.QAccount> members = this.<io.lcalmsky.app.modules.account.domain.entity.Account, io.lcalmsky.app.modules.account.domain.entity.QAccount>createSet("members", io.lcalmsky.app.modules.account.domain.entity.Account.class, io.lcalmsky.app.modules.account.domain.entity.QAccount.class, PathInits.DIRECT2);

    public final StringPath path = createString("path");

    public final BooleanPath published = createBoolean("published");

    public final DateTimePath<java.time.LocalDateTime> publishedDateTime = createDateTime("publishedDateTime", java.time.LocalDateTime.class);

    public final BooleanPath recruiting = createBoolean("recruiting");

    public final DateTimePath<java.time.LocalDateTime> recruitingUpdatedDateTime = createDateTime("recruitingUpdatedDateTime", java.time.LocalDateTime.class);

    public final StringPath shortDescription = createString("shortDescription");

    public final SetPath<io.lcalmsky.app.modules.tag.domain.entity.Tag, io.lcalmsky.app.modules.tag.domain.entity.QTag> tags = this.<io.lcalmsky.app.modules.tag.domain.entity.Tag, io.lcalmsky.app.modules.tag.domain.entity.QTag>createSet("tags", io.lcalmsky.app.modules.tag.domain.entity.Tag.class, io.lcalmsky.app.modules.tag.domain.entity.QTag.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public final BooleanPath useBanner = createBoolean("useBanner");

    public final SetPath<io.lcalmsky.app.modules.account.domain.entity.Zone, io.lcalmsky.app.modules.account.domain.entity.QZone> zones = this.<io.lcalmsky.app.modules.account.domain.entity.Zone, io.lcalmsky.app.modules.account.domain.entity.QZone>createSet("zones", io.lcalmsky.app.modules.account.domain.entity.Zone.class, io.lcalmsky.app.modules.account.domain.entity.QZone.class, PathInits.DIRECT2);

    public QStudy(String variable) {
        super(Study.class, forVariable(variable));
    }

    public QStudy(Path<? extends Study> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStudy(PathMetadata metadata) {
        super(Study.class, metadata);
    }

}

