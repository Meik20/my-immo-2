pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    // Empêche les modules d'ajouter leurs propres repositories
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    // Repositories globaux
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") } // Pour les dépendances JitPack
    }
}

rootProject.name = "My Immo2"
include(":app")
