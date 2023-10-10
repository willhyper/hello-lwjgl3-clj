# hello-lwjgl3-clj
learn and develop `lwjgl3` on `macos-arm64` using `clojure`

## preparation
1. `brew install clojure` to get `clojure` and `clj`
2. `brew install java` to get `java`

## how to run
`git tag` to list tags. `git checkout <tag>` and `./run.sh`

## learning notes
1. Apple depricates OpenGL in favor of its own Metal.
2. `-XstartOnFirstThread` as a JVM option is essential to MacOS (arm64?) users, or `.run.sh` will complain the same too.
3. `clj -A:some-alias` is depricated in favor of `clj -M:some-alias`. `:some-alias` such as `:macos-arm64` is defined in `deps.edn`
4. `clj -Sdescribe` shows its configuration.
5. add socket server remote REPL https://clojure.org/guides/deps_and_cli
6. `clj -X:deps find-versions :lib org.lwjgl/lwjgl` to know what versions available to put in `deps.edn`
7. `/usr/libexec/java_home -V` to know what JDKs are available locally. However, Homebrew's are at `/opt/homebrew/Cellar/openjdk`
