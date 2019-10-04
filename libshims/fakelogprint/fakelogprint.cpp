#include <log/log_transport.h>
#include <private/android_filesystem_config.h>
#include <private/android_logger.h>

#define UNUSED __attribute__((unused))

int __android_log_print(UNUSED int prio, UNUSED const char* tag, UNUSED const char* fmt, ...) {
  // Goodix: please don't spam that much!
  return 0;
}
