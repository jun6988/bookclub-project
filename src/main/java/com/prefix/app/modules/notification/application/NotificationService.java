package com.prefix.app.modules.notification.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prefix.app.modules.notification.domain.entity.Notification;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NotificationService {
    public void markAsRead(List<Notification> notifications) {
        notifications.forEach(Notification::read);
    }
}
