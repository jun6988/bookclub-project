package io.lcalmsky.app.modules.account.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccount_NotificationSetting is a Querydsl query type for NotificationSetting
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QAccount_NotificationSetting extends BeanPath<Account.NotificationSetting> {

    private static final long serialVersionUID = -2104631586L;

    public static final QAccount_NotificationSetting notificationSetting = new QAccount_NotificationSetting("notificationSetting");

    public final BooleanPath studyCreatedByEmail = createBoolean("studyCreatedByEmail");

    public final BooleanPath studyCreatedByWeb = createBoolean("studyCreatedByWeb");

    public final BooleanPath studyRegistrationResultByEmail = createBoolean("studyRegistrationResultByEmail");

    public final BooleanPath studyRegistrationResultByWeb = createBoolean("studyRegistrationResultByWeb");

    public final BooleanPath studyUpdatedByEmail = createBoolean("studyUpdatedByEmail");

    public final BooleanPath studyUpdatedByWeb = createBoolean("studyUpdatedByWeb");

    public QAccount_NotificationSetting(String variable) {
        super(Account.NotificationSetting.class, forVariable(variable));
    }

    public QAccount_NotificationSetting(Path<? extends Account.NotificationSetting> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccount_NotificationSetting(PathMetadata metadata) {
        super(Account.NotificationSetting.class, metadata);
    }

}

