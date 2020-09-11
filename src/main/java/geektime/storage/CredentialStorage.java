package geektime.storage;

/**
 * Created by pakwen on 12/4/19.
 */
public interface CredentialStorage {

  String getPasswordByAppID(String appId);
}
