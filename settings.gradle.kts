dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "lumora-addon-template"

// Public Lumora API (interfaces, events, settings, HudWidget). Built here so the template works without any
// external repository; at runtime the Lumora client mod provides the API.
include(":lumora-api")
// Your addon. Rename the folder and the ids in fabric.mod.json / lumora-addon.json for your own project.
include(":addon")
