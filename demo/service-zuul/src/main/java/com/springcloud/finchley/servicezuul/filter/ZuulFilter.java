package com.springcloud.finchley.servicezuul.filter;

import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class ZuulFilter extends com.netflix.zuul.ZuulFilter {

    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型。
     * 具体如下：
     * pre：    路由之前
     * routing：路由之时
     * post：   路由之后
     * error：  发送错误调用
     */

    @Override
    public String filterType() {
        return "pre";
    }

    // filterOrder：过滤的顺序
    @Override
    public int filterOrder() {
        return 0;
    }

    // shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
    @Override
    public boolean shouldFilter() {
        return true;
    }

    // run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(401);
            try {
                context.getResponse().getWriter().write("请求无token信息!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
