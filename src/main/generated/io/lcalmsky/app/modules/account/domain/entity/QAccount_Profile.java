package io.lcalmsky.app.modules.account.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccount_Profile is a Querydsl query type for Profile
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QAccount_Profile extends BeanPath<Account.Profile> {

    private static final long serialVersionUID = -514226398L;

    public static final QAccount_Profile profile = new QAccount_Profile("profile");

    public final StringPath bio = createString("bio");

    public final StringPath company = createString("company");

    public final StringPath image = createString("image");

    public final StringPath job = createString("job");

    public final StringPath location = createString("location");

    public final StringPath url = createString("url");

    public QAccount_Profile(String variable) {
        super(Account.Profile.class, forVariable(variable));
    }

    public QAccount_Profile(Path<? extends Account.Profile> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccount_Profile(PathMetadata metadata) {
        super(Account.Profile.class, metadata);
    }

}

