package sentrycrash;

import java.util.logging.*;
import com.google.gson.Gson;
import io.sentry.Sentry;
import io.sentry.jul.SentryHandler;

class SomeClass {
  public SomeClass(String id) throws Exception {
    // this exception causes sentry to blow up
    throw new Exception("test");
  }
}

public class Main {
  public static void main(String[] args) {
      java.util.logging.Logger logger = java.util.logging.Logger.getLogger("com.sentrycrash");
      ConsoleHandler consoleHandler = new ConsoleHandler();
      logger.addHandler(consoleHandler);
      String dsn = System.getenv("SENTRY_URL");
      Sentry.init(dsn + "?stacktrace.app.packages=sentrycrash&async.gracefulshutdown=false");
      SentryHandler sentryHandler = new SentryHandler();
      sentryHandler.setLevel(Level.SEVERE);
      logger.addHandler(sentryHandler);
      try {
        new Gson();

        new SomeClass("");
      } catch (Exception e) {
        logger.log(Level.SEVERE, "An error occurred", e);
      }
  }
}
