package com.example.backathena.repository;

import com.example.backathena.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findAllByUserId(Long id);
    Optional<Notification> getNotificationById(Long id);
}
