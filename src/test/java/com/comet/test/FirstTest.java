package com.comet.test;

import com.comet.BaseTest;
import com.comet.adapters.BotAdapter;
import com.comet.model.dto.AddMembersRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.cassandra.DataCassandraTest;

import java.util.List;

public class FirstTest extends BaseTest {

    @Autowired
    private BotAdapter botAdapter;

    //1741200962
    //1599303125

    @Test
    void someTest(){
        botAdapter.addMembers(AddMembersRequest.builder()
                        .chatId("-1001741200962")
                        .members(List.of("750120380"))
                .build());
    }
}
