# load our Spring Boot rule
load("//tools/springboot:springboot.bzl", "springboot")


# create our deps list for Spring Boot
springboot_deps = [
    "//tools/springboot/import_bundles:springboot_required_deps",
    "//tools/springboot/import_bundles:springboot_jetty_starter_deps",
    "//tools/springboot/import_bundles:springboot_web_starter_deps",
]

# This Java library contains the app code
java_library(
    name = "bookstore_lib",
    srcs = glob(["src/main/java/**/*.java"]),
    resources = glob(["src/main/resources/**"]),
    deps = springboot_deps,
)

# Build the app as a Spring Boot executable jar
springboot(
    name = "bookstore",
    boot_app_class = "space.bookstore.BookstoreApplication",
    java_library = ":bookstore_lib",
    deps = springboot_deps,
)
