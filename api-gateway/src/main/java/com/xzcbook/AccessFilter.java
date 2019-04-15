package com.xzcbook;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author shan
 * @date 2019/4/15
 */
public class AccessFilter extends ZuulFilter
{

  private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

  @Override
  public String filterType()
  {
    return "pre";
  }

  @Override
  public int filterOrder()
  {
    return 0;
  }

  @Override
  public boolean shouldFilter()
  {
    return true;
  }

  @Override
  public Object run()
  {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

    Object xzc = request.getParameter("xzc");
    if (xzc == null)
    {
      log.warn("xzc token is empty");
      ctx.setSendZuulResponse(false);
      ctx.setResponseStatusCode(401);
      return null;
    }
    log.info("xzc token ok");
    return null;
  }
}
