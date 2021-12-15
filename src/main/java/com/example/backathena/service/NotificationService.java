package com.example.backathena.service;

import com.example.backathena.entity.Notification;
import com.example.backathena.entity.Post;
import com.example.backathena.repository.NotificationRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final PostService postService;

    @Autowired
    public NotificationService(NotificationRepository notificationRepository, PostService postService){
        this.notificationRepository = notificationRepository;
        this.postService = postService;
    }

    public Notification save(Notification notification) {
        return notificationRepository.save(notification);
    }

    public List<Notification> getNotificationsByUser(Long userId) {
        return notificationRepository.findAllByUserId(userId);
    }

    public void readNotification(Long notificationId) {
        Optional<Notification> optionalNotification = notificationRepository.getNotificationById(notificationId);
        if (optionalNotification.isPresent()){
            Notification notification1 = optionalNotification.get();
            notification1.setRead(true);
            notificationRepository.save(notification1);
        }
    }
}
