# hello-lwjgl3-clj
learn and develop `lwjgl3` on `macos-arm64` using `clj`

## how to run
`git tag` to list tags. `git checkout <tag>` and `./run.sh`

## learning notes
1. Apple depricates OpenGL in favor of its own Metal.
2. `-XstartOnFirstThread` as a JVM option is essential to MacOS (arm64?) users, or `.run.sh` will complain the same too.
3. `clj -A:some-alias` is depricated in favor of `clj -M:some-alias`. `:some-alias` such as `:macos-arm64` is defined in `deps.edn`
4. `clj -Sdescribe` shows its configuration.
5. add socket server remote REPL https://clojure.org/guides/deps_and_cli
