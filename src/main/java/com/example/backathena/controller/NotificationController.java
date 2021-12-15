package com.example.backathena.controller;

import com.example.backathena.entity.Notification;
import com.example.backathena.repository.NotificationRepository;
import com.example.backathena.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notification")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService){
        this.notificationService = notificationService;
    }

    @PostMapping("")
    public Notification createNotification(@RequestBody Notification notification){
        return notificationService.save(notification);
    }

    @GetMapping("/{userId}")
    public List<Notification> getNotificationsByUser(@PathVariable Long userId){
        return notificationService.getNotificationsByUser(userId);
    }


    @PutMapping("/{notificationId}")
    public void readNotification(@PathVariable Long notificationId){
        notificationService.readNotification(notificationId);
    }
}
