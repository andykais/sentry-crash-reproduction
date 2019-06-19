# Sentry crash reproduction

## Setup
```bash
./gradlew
```

## Running
```bash
SENTRY_URL="<a valid sentry project url>" java  -agentpath:$PWD/lib/3rd-party/libsentry_agent.dylib -jar ./build/libs/sentrycrash.jar
```

## Sample crash output
```
Jun 19, 2019 11:45:22 AM sentrycrash.Main main
SEVERE: An error occurred
java.lang.Exception: test
	at sentrycrash.SomeClass.<init>(Main.java:11)
	at sentrycrash.Main.main(Main.java:28)

#
# A fatal error has been detected by the Java Runtime Environment:
#
#  SIGSEGV (0xb) at pc=0x0000000105b4c0f1, pid=36721, tid=0x0000000000001903
#
# JRE version: Java(TM) SE Runtime Environment (8.0_192-b12) (build 1.8.0_192-b12)
# Java VM: Java HotSpot(TM) 64-Bit Server VM (25.192-b12 mixed mode bsd-amd64 compressed oops)
# Problematic frame:
# J 239 C2 java.lang.String.equals(Ljava/lang/Object;)Z (81 bytes) @ 0x0000000105b4c0f1 [0x0000000105b4c080+0x71]
#
# Failed to write core dump. Core dumps have been disabled. To enable core dumping, try "ulimit -c unlimited" before starting Java again
#
# An error report file with more information is saved as:
# /Users/andrew/Code/development/sample-broken-sentry/hs_err_pid36721.log
#
# If you would like to submit a bug report, please visit:
#   http://bugreport.java.com/bugreport/crash.jsp
#
[1]    36721 abort      SENTRY_URL="https://20110e9223844989897c6a59dfb7b57b@sentry.io/1439658" java
```
