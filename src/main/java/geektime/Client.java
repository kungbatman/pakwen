package geektime;

import geektime.auth.DefaultApiAuthencatorImpl;

/**
 * Created by pakwen on 12/4/19.
 */
public class Client {

  public static void main(String[] args) {
    String req = "geekbang?"
        + "AppID=designpattern"
        + "&Token=IXIGIpJ9hdOBCyjStaDJ5Nom07g="
        + "&Timestamp=1465185768";

    DefaultApiAuthencatorImpl authencator = new DefaultApiAuthencatorImpl();
    authencator.auth(req);
//    buildAuthToken: IXIGIpJ9hdOBCyjStaDJ5Nom07g=
//    pass auth!
  }
}
