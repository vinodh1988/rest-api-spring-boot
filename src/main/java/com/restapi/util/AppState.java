package com.restapi.util;

import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;

@Component
@ApplicationScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class AppState {
  private Integer state=0;
  
  public void setState() {
	  state++;
  }
  
  public Integer getState() {
	  return state;
  }
}
