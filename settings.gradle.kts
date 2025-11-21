pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        // Repositories globaux autorisés
        mavenCentral()

        // JitPack (filtré uniquement pour ton dépôt)
        maven {
            url = uri("https://jitpack.io")
            content {
                includeGroup("com.github.Meik20")
            }
        }

        // Exemple d'un autre repo (mais il exclut ton group)
        maven {
            url = uri("https://other repository")
            content {
                excludeGroupByRegex("com\\.github\\.Meik20.*")
            }
        }
    }
}

rootProject.name = "My Immo2"
include(":app")
 