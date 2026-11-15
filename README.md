# Bloom

A Minecraft 1.21.11 Fabric client.

## Requirements

- JDK 21
- Gradle 9 (wrapper included, no install needed)

## Build

```
gradlew build
```

On Unix:

```
./gradlew build
```

Output is written to `build/libs/bloom-29.0.0.1.jar`.

To skip tests and jump straight to the artifact:

```
gradlew assemble
```

## Dependencies

| Component     | Version           |
| ------------- | ----------------- |
| Minecraft     | 1.21.11           |
| Yarn mappings | 1.21.11+build.6   |
| Fabric Loader | 0.20.1            |
| Fabric API    | 0.141.6+1.21.11   |
| Fabric Loom   | 1.17.21           |

All versions are pinned in `gradle.properties`.

## Layout

```
src/main/java        client source
src/main/resources   mod metadata, mixin configs, fonts, shaders, access widener
```

Source packages:

- `net.caffeinemc.mods.lithium.lattice.bundle.*` — render pipeline, overlays, HUD, module bindings
- `net.caffeinemc.mods.lithium.binder.*` — bootstrap and service bindings
- `com.blamejared.clumps.*` — bundled orb-clumping module

The client entrypoint is declared in `fabric.mod.json`:

```
net.caffeinemc.mods.lithium.lattice.bundle.pipeline.RenderController
```

## Notes

- Mixin configurations are `clumps.mixins.json` and `clumps.compat.json`; the
  refmap is generated during the build.
- `lithium.accesswidener` targets intermediary names and must stay in
  `src/main/resources`. Loom rewrites it during `remapJar`; the "cannot remap"
  lines it prints for entries that moved between Minecraft versions are
  warnings, not build failures.
- The bundled fonts and shaders under `assets/lithium` are loaded at runtime and
  are not embedded into the class output.

## Third-party

See [THIRD-PARTY.md](THIRD-PARTY.md).
