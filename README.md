A simple spring boot app to play around with bazel build tool.

To build your java app:

1. brew install bazel
2. Make sure to have /tools/springboot directory along with BUILD and WORKSPACE files
3. bazel build //:bookstore
4. You may now find your Spring Boot application built in /bazel-bin directory (softlink)
