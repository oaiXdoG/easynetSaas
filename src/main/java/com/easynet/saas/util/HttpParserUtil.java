package com.easynet.saas.util;

import com.easynet.core.internal.packet.DecodePacket;
import com.easynet.core.internal.router.attachment.HttpAttachment;
import com.easynet.saas.protocol.BaseAuthRequest;
import com.easynet.utils.GsonUtils;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;

import java.nio.charset.StandardCharsets;

/**
 * HTTP请求解析工具
 */
public final class HttpParserUtil {

    private HttpParserUtil() {
    }

    /**
     * 解析 JSON 并自动设置 Token（用于需要认证的接口）
     */
    public static DecodePacket jsonParserWithToken(FullHttpRequest request, Class<?> businessClass) {
        String jsonContent = null;
        try {
            jsonContent = request.content().toString(StandardCharsets.UTF_8);
            Object businessObject = GsonUtils.fromJson(jsonContent, businessClass);

            if (businessObject instanceof BaseAuthRequest) {
                String authHeader = request.headers().get("Authorization");
                if (authHeader != null && authHeader.startsWith("Bearer ")) {
                    ((BaseAuthRequest) businessObject).setToken(authHeader.substring(7));
                }
            }

            return DecodePacket.valueOf(businessObject, HttpAttachment.valueOf(request, HttpResponseStatus.OK));
        } catch (Exception e) {
            throw new RuntimeException(String.format("Failed to parse JSON to %s, content: %s", businessClass.getSimpleName(), jsonContent));
        }
    }
}
