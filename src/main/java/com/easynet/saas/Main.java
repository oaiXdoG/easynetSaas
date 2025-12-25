package com.easynet.saas;

import com.easynet.bootstrap.Bootstrap;
import com.easynet.core.internal.core.http.HttpServer;
import com.easynet.core.internal.dto.HostAndPort;
import com.easynet.core.internal.packet.DecodePacket;
import com.easynet.core.internal.router.attachment.HttpAttachment;
import com.easynet.saas.protocol.LoginRequest;
import com.easynet.utils.PropertiesConfigUtils;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;

import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap.startup(Main.class);

        int port = PropertiesConfigUtils.getInt("http.port", 8080);
        HttpServer httpServer = new HttpServer(HostAndPort.valueOf("192.168.41.66", port));
        httpServer.register("/ez/login", new Function<FullHttpRequest, DecodePacket>() {
            @Override
            public DecodePacket apply(FullHttpRequest request) {
                return DecodePacket.valueOf(new LoginRequest(), HttpAttachment.valueOf(request, HttpResponseStatus.OK));
            }
        });
        httpServer.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            Bootstrap.startup(Main.class);
        }));

        Thread.currentThread().join();


    }
}