package umc.spring.web.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import umc.spring.web.dto.DiscordMessage;


@FeignClient(name = "discord-client", url="https://discord.com/api/webhooks/1370567792037855333/UQwXCj_Ur8rGWf9-qxlSQNR-cBVpmFrcNp7Cm6vAmzKP3Iy-6YCj-S5sWSWiYIPPTTXa")
public interface DiscordClient {

    @PostMapping
    void sendAlarm(@RequestBody DiscordMessage message);
}