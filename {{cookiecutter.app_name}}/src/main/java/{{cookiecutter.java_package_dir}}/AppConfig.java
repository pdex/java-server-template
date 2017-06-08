package {{cookiecutter.java_package}};

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class AppConfig {
  private final Config config = ConfigFactory.load();

  public AppConfig() {

  }

  public int readerIdleTimeout() {
    return config.getInt("limits.reader_idle_timeout");
  }

  public int writerIdleTimeout() {
    return config.getInt("limits.writer_idle_timeout");
  }

  public int requestIdleTimeout() {
    return config.getInt("limits.request_idle_timeout");
  }

  public String bossNameFormat() {
    return config.getString("boss.name_format");
  }

  public int bossThreads() {
    return config.getInt("boss.threads");
  }

  public String workerNameFormat() {
    return config.getString("worker.name_format");
  }

  public int workerThreads() {
    return config.getInt("worker.threads");
  }


  public int maxConnections() {
    return config.getInt("limits.max_connections");
  }

  public float rateLimit() {
    return (float) config.getInt("limits.req_per_sec");
  }

  public int httpMessageSize() {
    return config.getBytes("limits.http_message_size").intValue();
  }

  public String cert() {
    return config.getString("tls.cert");
  }

  public String key() {
    return config.getString("tls.key");
  }

  public String ip() {
    return config.getString("server.ip");
  }

  public int port() {
    return config.getInt("server.port");
  }

}
