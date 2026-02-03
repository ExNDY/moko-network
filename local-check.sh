#
# Copyright 2022 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
#

set -e

log() {
  echo "\033[0;32m> $1\033[0m"
}

# run gradle tasks in faster order to receive faster feedback
./gradlew -p network-generator detekt
log "plugin detekt success"

./gradlew -p network-generator build publishToMavenLocal
log "plugin build and publish success"

./gradlew detekt
log "runtime detekt success"

./gradlew assembleDebug
log "runtime android success"

./gradlew compileKotlinIosX64
log "runtime ios success"

./gradlew build publishToMavenLocal syncMultiPlatformLibraryDebugFrameworkIosX64
log "runtime build and publish success"
