package com.easynet.saas;

import com.easynet.bootstrap.Bootstrap;
import com.easynet.core.internal.core.http.HttpServer;
import com.easynet.core.internal.dto.HostAndPort;
import com.easynet.core.internal.packet.HttpRequestParser;
import com.easynet.saas.protocol.LoginRequest;
import com.easynet.utils.PropertiesConfigUtils;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap.startup(Main.class);

        int port = PropertiesConfigUtils.getInt("http.port", 8080);
        HttpServer httpServer = new HttpServer(HostAndPort.valueOf("192.168.41.66", port));
        httpServer.register("/api/auth/login", request -> HttpRequestParser.jsonParser(request,LoginRequest.class));
        httpServer.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Bootstrap.startup(Main.class);
        }));

        Thread.currentThread().join();


    }
}