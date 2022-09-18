package com.comet.adapters;

import com.comet.model.dto.AddAdminRequest;
import com.comet.model.dto.AddMembersRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "bot-adapter",
        url = "http://localhost:8080/")
public interface BotAdapter {

    @PostMapping(value = "members")
    void addMembers(@RequestBody AddMembersRequest addMembersRequest);

    @PostMapping(value = "admin")
    void addAdmin(@RequestBody AddAdminRequest addAdminRequest);

}
