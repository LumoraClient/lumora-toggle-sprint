allprojects {
    group = providers.gradleProperty("addon.group").get()
}

subprojects {
    plugins.withType<JavaPlugin> {
        extensions.configure<JavaPluginExtension> {
            // Java 21 is the oldest runtime of the supported Minecraft versions.
            toolchain.languageVersion.set(JavaLanguageVersion.of(21))
        }
        tasks.withType<JavaCompile>().configureEach {
            options.encoding = "UTF-8"
            options.release.set(21)
            options.compilerArgs.addAll(listOf("-Xlint:all,-serial,-processing,-this-escape", "-Werror"))
        }
    }
}
