package com.sthg.web.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.Inet4Address;
import java.net.UnknownHostException;

@Component
@Slf4j
public class SwaggerPrintConfig implements ApplicationListener<WebServerInitializedEvent> {

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        String hostAddress = null;
        try {
            hostAddress = Inet4Address.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        int port = event.getWebServer().getPort();
        String applicationName = event.getApplicationContext().getApplicationName();
        log.info(" \n---------------------------------\n\t" +
                "swagger文档:\thttp://" + hostAddress + ":" + port + applicationName + "/doc.html\n" +
                "-----------------------------------");
    }
}
