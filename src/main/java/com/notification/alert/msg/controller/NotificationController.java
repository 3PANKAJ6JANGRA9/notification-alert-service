package com.notification.alert.msg.controller;

import com.notification.alert.msg.dto.NotificationDTO;
import com.notification.alert.msg.service.NotificationService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="notification")
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService)
    {
        this.notificationService=notificationService;
    }

    @PostMapping()
    public ResponseEntity<String>sendNotification(@RequestBody NotificationDTO notificationDTO)
    {
        try
        {
            notificationService.sendNotification(
                    notificationDTO.getRecipient(),
                    notificationDTO.getMessage(),
                    notificationDTO.getChannel()

            );
            return ResponseEntity.ok("Notification send Successfully via channel:"+notificationDTO.getChannel());
        }

        catch (IllegalArgumentException e) {
        // Catches invalid channels (e.g., if someone passes channel="pager")
        return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.internalServerError().body("An error occurred: " + e.getMessage());
    }
    }
    @GetMapping(path="{recipientName}")
    public ResponseEntity<String> getRecipentByName(@PathVariable String recipientName)
    {
        String mockRecipient ="Fetch Details for the recipient :"+recipientName;
        return ResponseEntity.ok(mockRecipient);
    }


}
