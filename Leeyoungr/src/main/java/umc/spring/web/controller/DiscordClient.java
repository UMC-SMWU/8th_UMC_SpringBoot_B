package umc.spring.web.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import umc.spring.web.dto.DiscordMessage;


@FeignClient(name = "discord-client")
public interface DiscordClient {

    @PostMapping
    void sendAlarm(@RequestBody DiscordMessage message);
}