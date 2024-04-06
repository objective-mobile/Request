pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "request"
include(":app")
include(":openai")
include(":openai:data")
include(":openai:domain")
include(":search:data")
include(":search:domain")
include(":answer:presentation")
include(":di")
include(":openai:di")
include(":core")
include(":core:data")